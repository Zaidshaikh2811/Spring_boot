    package com.child1.hospital.mapper;


    import com.child1.hospital.dto.request.AppointmentRequest;
    import com.child1.hospital.dto.request.DoctorRequest;
    import com.child1.hospital.dto.response.DoctorResponse;
    import com.child1.hospital.model.Appointment;
    import com.child1.hospital.model.Doctor;
    import org.springframework.data.domain.Page;
    import org.springframework.stereotype.Component;

    import java.util.List;

    @Component
    public class DoctorMapper {

        private final AppointmentMapper appointmentMapper;

        public DoctorMapper(AppointmentMapper appointmentMapper) {
            this.appointmentMapper = appointmentMapper;
        }

        // Entity → Response
        public DoctorResponse toDoctorResponse(Doctor doctor) {
            DoctorResponse response = new DoctorResponse();
            response.setId(doctor.getId());
            response.setName(doctor.getName());
            response.setSpecialty(doctor.getSpecialty());

            if (doctor.getAppointments() != null) {
                response.setAppointments(
                        doctor.getAppointments()
                                .stream()
                                .map(appointmentMapper::toResponse)
                                .toList()
                );
            } else {
                response.setAppointments(List.of());
            }

            return response;
        }

        // Request → Entity
        public Doctor toEntity(DoctorRequest request) {
            Doctor doctor = new Doctor();
            doctor.setName(request.getName());
            doctor.setSpecialty(request.getSpecialty());
            return doctor;
        }

        // List mapping
        public List<DoctorResponse> toDoctorResponses(List<Doctor> doctors) {
            return doctors.stream()
                    .map(this::toDoctorResponse)
                    .toList();
        }


        public Page<DoctorResponse> toPageDoctorResponses(Page<Doctor> doctors) {
            return doctors.map(this::toDoctorResponse);
        }

    }
