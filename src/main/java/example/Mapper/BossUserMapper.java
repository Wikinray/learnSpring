package example.Mapper;


import example.entity.BossUser;
import org.springframework.data.repository.CrudRepository;

public interface BossUserMapper extends CrudRepository<BossUser,String> {
}
