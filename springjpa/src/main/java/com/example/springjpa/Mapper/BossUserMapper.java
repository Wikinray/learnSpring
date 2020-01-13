package com.example.springjpa.Mapper;


import com.example.springjpa.entity.BossUser;
import org.springframework.data.repository.CrudRepository;

public interface BossUserMapper extends CrudRepository<BossUser,String> {
}
