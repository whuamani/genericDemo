package pe.perseo.genericDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity,Integer> {

    //findAll : automatico
}
