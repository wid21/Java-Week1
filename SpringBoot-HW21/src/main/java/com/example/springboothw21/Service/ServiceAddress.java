package com.example.springboothw21.Service;

import com.example.springboothw21.ApiException.ApiException;
import com.example.springboothw21.Dto.DtoAddress;
import com.example.springboothw21.Model.Address;
import com.example.springboothw21.Model.Teacher;
import com.example.springboothw21.Repository.RepositoryAddress;
import com.example.springboothw21.Repository.RepositoryTeacher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceAddress {

    private final RepositoryAddress repositoryAddress;
    private final RepositoryTeacher repositoryTeacher;


    public void addAdress(DtoAddress dtoAddress){
        Teacher teacher=repositoryTeacher.findTeacherById(dtoAddress.getTeacher_id());
        if(teacher==null){
            throw new ApiException("not found");
        }
        Address address= new Address(null,dtoAddress.getArea(),dtoAddress.getStreet(),dtoAddress.getBuildingNumber(),teacher);
        repositoryAddress.save(address);
    }

    public void updateAddress(Address address ) {
        Teacher teacher=repositoryTeacher.findTeacherById(address.getId());
        if (teacher == null) {
            throw new ApiException("Address not found");
        }

        address.setArea(address.getArea());
        address.setStreet(address.getStreet());
        address.setBuildingNumber(address.getBuildingNumber());
        address.setTeacher(teacher);

        repositoryAddress.save(address);
    }

    public void deleteAddress(Integer id) {
        Teacher t = repositoryTeacher.findTeacherById(id);
        if (t == null) {
            throw new ApiException("not found");
        }
        Address address = repositoryAddress.findAddressById(t.getId());
        if (address == null) {
            throw new ApiException("this id do not have address");
        }
        repositoryAddress.delete(address);

    }




}
