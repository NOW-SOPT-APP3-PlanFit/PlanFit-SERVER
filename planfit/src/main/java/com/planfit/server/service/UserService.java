package com.planfit.server.service;

import com.planfit.server.common.exception.NotFoundException;
import com.planfit.server.common.message.ErrorMessage;
import com.planfit.server.domain.User;
import com.planfit.server.dto.request.UserPutRequest;
import com.planfit.server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.USER_NOT_FOUND));
    }

    @Transactional
    public void updateUser(Long userId, UserPutRequest request) {
        User user = getUserById(userId);
        user.update(request);
    }
}
