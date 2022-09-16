package ramanujd.github.io.core.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ramanujd.github.io.core.app.model.PhoneDetails;

public interface PhoneDetailsRepository extends JpaRepository<PhoneDetails, Long> {
}
