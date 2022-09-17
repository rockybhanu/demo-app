package ramanujd.github.io.core.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ramanujd.github.io.core.app.model.Instrument;

public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
}
