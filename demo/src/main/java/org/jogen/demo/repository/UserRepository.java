package org.jogen.demo.repository;

import org.jogen.demo.po.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Jogen
 */
public interface UserRepository extends MongoRepository<User, String>{
}
