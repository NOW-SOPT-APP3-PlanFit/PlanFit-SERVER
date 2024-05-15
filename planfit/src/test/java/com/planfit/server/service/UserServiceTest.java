package com.planfit.server.service;

import com.planfit.server.common.exception.NotFoundException;
import com.planfit.server.common.message.ErrorMessage;
import com.planfit.server.domain.User;
import com.planfit.server.repository.UserRepository;
import com.planfit.server.utils.UserTestUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void 회원_id_기반_검색_성공() {
        // given
        var userId = 1L;
        var expectedUser = UserTestUtil.createUser();
        given(userRepository.findById(userId)).willReturn(Optional.of(expectedUser));

        // when
        var actualUser = userService.getUserById(userId);

        // then
        assertThat(actualUser).isEqualTo(expectedUser);
    }

    @Test
    void 회원_id_기반_검색_실패() {
        // given
        var userId = 1L;
        given(userRepository.findById(userId)).willReturn(Optional.empty());

        // when, then
        assertThatThrownBy(() -> userService.getUserById(userId))
                .isInstanceOf(NotFoundException.class)
                .hasMessage(ErrorMessage.USER_NOT_FOUND.getMessage());
    }

    @Test
    void 회원_정보_수정_전체() {
        // given
        var userId = 1L;
        var user = UserTestUtil.createUser();
        var updateRequest = UserTestUtil.createPutRequest();
        given(userRepository.findById(userId)).willReturn(Optional.of(user));

        // when
        userService.updateUser(userId, updateRequest);

        // then
        User updatedUser = userService.getUserById(userId);
        assertThat(updatedUser.getMinute()).isEqualTo(user.getMinute());
        assertThat(updatedUser.getCondition()).isEqualTo(user.getCondition());
    }
}