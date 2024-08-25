package com.example.jparelationi.Controller;

import com.example.jparelationi.ApiResponse.ApiResponse;
import com.example.jparelationi.DTO.AddressDTO;
import com.example.jparelationi.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;
    @GetMapping("/get")
   public ResponseEntity getAddress(){
       return ResponseEntity.status(200).body(addressService.getAllAddress());
   }
   @PostMapping("/add")
   public ResponseEntity addAddressToTeacher(@Valid@RequestBody AddressDTO addressDTO){
        addressService.addAddressToTeacher(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("is added"));
   }
    @PutMapping("/update")
   public ResponseEntity updateAddress(@Valid@RequestBody AddressDTO addressDTO){
        addressService.updateAddress(addressDTO);
        return ResponseEntity.status(200).body("is updated");
   }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body("is deleted");
    }


}
