package ir.omidashouri.marsroverapi.repository;

import ir.omidashouri.marsroverapi.dto.HomeDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferencesRepository extends JpaRepository<HomeDto,Long> {

    HomeDto findByUserId(Long userId);
}
