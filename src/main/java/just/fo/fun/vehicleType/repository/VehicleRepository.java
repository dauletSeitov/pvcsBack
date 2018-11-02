package just.fo.fun.vehicleType.repository;

import just.fo.fun.entities.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<VehicleType, Long> {
}
