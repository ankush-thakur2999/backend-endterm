package com.upgrad.Endterm.Service;

import com.upgrad.Endterm.Exception.RecordNotFoundException;
import com.upgrad.Endterm.Model.User;
import com.upgrad.Endterm.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getAllEmployees()
    {
        System.out.println("getAllEmployees");
        List<User> result = (List<User>) userRepository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<User>();
        }
    }
    public User getUserById(Long id) throws RecordNotFoundException
    {
        System.out.println("getEmployeeById");
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()) {
            return user.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
    public void deleteUserById(Long id) throws RecordNotFoundException
    {
        System.out.println("deleteUserById");

        Optional<User> employee = userRepository.findById(id);

        if(employee.isPresent())
        {
            userRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
    public User createOrUpdateUser(User user)
    {
        System.out.println("createOrUpdateEmployee");
        // Create new entry
        if(user.getId()  == null)
        {
            user = userRepository.save(user);

            return user;
        }
        else
        {
            // update existing entry
            Optional<User> employee = userRepository.findById(user.getId());

            if(employee.isPresent())
            {
                User newEntity = employee.get();
                newEntity.setEmail(user.getEmail());
                newEntity.setName(user.getName());
                newEntity.setAddress(user.getAddress());
                newEntity.setAge(user.getAge());

                newEntity = userRepository.save(newEntity);

                return newEntity;
            } else {
                user = userRepository.save(user);

                return user;
            }
        }
    }
}