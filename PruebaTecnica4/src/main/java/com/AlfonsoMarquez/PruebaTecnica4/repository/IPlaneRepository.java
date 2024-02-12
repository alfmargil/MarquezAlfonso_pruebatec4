package com.AlfonsoMarquez.PruebaTecnica4.repository;

import com.AlfonsoMarquez.PruebaTecnica4.model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlaneRepository extends JpaRepository<Plane,Long> {
    public Plane findByPlaneId(Long planeId);
}
