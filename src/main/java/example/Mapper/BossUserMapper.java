package example.Mapper;


import com.example.demo.entity.BossUser;
import org.springframework.data.repository.CrudRepository;

public interface BossUserMapper extends CrudRepository<BossUser,String> {
}
