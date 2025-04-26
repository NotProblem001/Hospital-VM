package com.example.hospital_vm.repository;

import com.example.hospital_vm.model.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{

    // Encuentra pacientes por apellidos
    // Usando JPQL
    @Query("SELECT p FROM Paciente p WHERE p.apellidos = :apellidos")
    List<Paciente> findByApellidos(@Param("apellidos")String apellidos);

    // Encuentra pacientes por correo electronico
    // Usando SQL nativo
    @Query(value = "SELECT * FROM paciente WHERE correo = :correo", nativeQuery = true)
    Paciente findByCorreo(@Param("correo")String correo);

    // Encuentra pacientes por nombre y apellido
    List<Paciente> findByNombresAndApellidos(String nombres, String apellidos);

}
