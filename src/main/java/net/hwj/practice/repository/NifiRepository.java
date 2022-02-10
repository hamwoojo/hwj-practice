package net.hwj.practice.repository;

import net.hwj.practice.model.Nifi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NifiRepository extends JpaRepository<Nifi,String> , JpaSpecificationExecutor<Nifi> {

    Nifi findOneByIp(String Ip);

    Nifi findNifiByIp(String Ip);
}
