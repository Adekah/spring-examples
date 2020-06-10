package com.adekah.service.impl;

import com.adekah.dto.UserDto;
import com.adekah.entity.Address;
import com.adekah.entity.User;
import com.adekah.repository.AdresRepository;
import com.adekah.repository.UserRepository;
import com.adekah.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AdresRepository adresRepository;

    @Override
    @Transactional
    public UserDto save(UserDto userDto) {
        Assert.notNull(userDto.getName(), "Name  parameter is required");

        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        final User userDb = userRepository.save(user);

        List<Address> addressList = new ArrayList<>();
        userDto.getAddresses().forEach(addRessitem -> {
            Address address = new Address();
            address.setAddress(addRessitem);
            address.setAddressType(Address.AdressType.OTHER);
            address.setIsActive(true);
            address.setUser(userDb);
            addressList.add(address);
        });
        adresRepository.saveAll(addressList);
        userDto.setId(userDb.getId());
        return userDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();

        users.forEach(userItem -> {
            UserDto userDto = new UserDto();
            userDto.setId(userItem.getId());
            userDto.setName(userItem.getName());
            userDto.setAddresses(
                    userItem.getAddresses() != null ?
                            userItem.getAddresses().stream().map(Address::getAddress).collect(Collectors.toList()) : null);
            userDtos.add(userDto);
        });
        return userDtos;
    }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        return null;
    }


}
