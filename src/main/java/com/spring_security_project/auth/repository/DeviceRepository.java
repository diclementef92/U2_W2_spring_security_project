package com.spring_security_project.auth.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring_security_project.auth.entity.Device;
import com.spring_security_project.auth.entity.EDeviceState;
import com.spring_security_project.auth.entity.EDeviceType;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

	Optional<List<Device>> findByType(EDeviceType type);

	Optional<List<Device>> findByState(EDeviceState state);

	Optional<List<Device>> findByModelDescription(String description);

//	// SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Company c WHERE
//	// c.name = :companyName"
//	@Query("Select case when count(d)>0 Then true Else false END from Device d where d.state = 'Available' and d.id = ?1")
//	boolean isAvailable(Long id);

}
