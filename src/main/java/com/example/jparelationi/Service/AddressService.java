package com.example.jparelationi.Service;

import com.example.jparelationi.ApiExption.ApiExaption;
import com.example.jparelationi.DTO.AddressDTO;
import com.example.jparelationi.Model.Address;
import com.example.jparelationi.Model.Teacher;
import com.example.jparelationi.Repository.AddressRepository;
import com.example.jparelationi.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;
   public List<Address> getAllAddress(){
       return addressRepository.findAll();
   }

   public void addAddressToTeacher(AddressDTO addressDTO){
       Teacher teacher=teacherRepository.findTeacherById(addressDTO.getTeacher_id());
       if(teacher==null){
           throw  new ApiExaption("not found");
       }
       Address address=new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
       addressRepository.save(address);
   }

   public void updateAddress(AddressDTO addressDTO){
       Address address=addressRepository.findAddressById(addressDTO.getTeacher_id());
       if(address==null){
           throw new ApiExaption("not found");
       }
       address.setStreet(addressDTO.getStreet());
       address.setArea(addressDTO.getArea());
       address.setBuildingNumber(addressDTO.getBuildingNumber());
       addressRepository.save(address);

   }

   public void deleteAddress(Integer id){
       Teacher teacher=teacherRepository.findTeacherById(id);
       if(teacher==null){
           throw new ApiExaption("not found");
       }
       teacherRepository.delete(teacher);
   }

}
