package com.mkyong;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkyong.domaine.Formation;

public interface FormationRepository extends JpaRepository<Formation, Long> {
  List<Formation> findByTheme(String theme);
  void deleteById(Long id);
  List<Formation> findByThemeContaining(String search);

}
