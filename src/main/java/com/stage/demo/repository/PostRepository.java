package com.stage.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stage.demo.model.*;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

	List<PostEntity> findByTitle(String title);

}
