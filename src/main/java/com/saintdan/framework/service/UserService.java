package com.saintdan.framework.service;

import com.saintdan.framework.exception.RoleException;
import com.saintdan.framework.exception.UserException;
import com.saintdan.framework.param.UserParam;
import com.saintdan.framework.po.User;
import com.saintdan.framework.vo.ObjectsVO;
import com.saintdan.framework.vo.PageVO;
import com.saintdan.framework.vo.UserVO;
import org.springframework.data.domain.Pageable;

/**
 * User's service.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 7/21/15
 * @since JDK1.8
 */
public interface UserService {

    /**
     * Create new user.
     *
     * @param currentUser   current user
     * @param param         user's params
     * @return              user's VO
     * @throws UserException        USR0031 User already existing exception, usr taken
     * @throws RoleException        ROL0012 Cannot find any role by this id param.
     */
    UserVO create(UserParam param, User currentUser) throws UserException, RoleException;

    /**
     * Show all users' VO.
     *
     * @return          users' VO
     * @throws UserException        USR0011 No user yet
     */
    ObjectsVO getAllUsers() throws UserException;

    /**
     * Show users' page VO.
     *
     * @param pageable      page
     * @return              users' page VO
     * @throws UserException        USR0011 No user exists.
     */
    PageVO getPage(Pageable pageable) throws UserException;

    /**
     * Show users by ids.
     *
     * @param ids           users' ids
     * @return              users' PO
     * @throws UserException        USR0012 Cannot find any user by this id param.
     */
    Iterable<User> getUsersByIds(Iterable<Long> ids) throws UserException;

    /**
     * Show user's VO.
     *
     * @param param     user's params
     * @return          user's VO
     * @throws UserException        USR0012 Cannot find any user by this id param.
     */
    UserVO getUserById(UserParam param) throws UserException;

    /**
     * Get user's VO by param.
     *
     * @param param     user's params
     * @return          user's VO
     * @throws UserException        USR0013 Cannot find any user by this usr param.
     */
    UserVO getUserByUsr(UserParam param) throws UserException;


    /**
     * Update user.
     *
     * @param currentUser   current user
     * @param param         user's params
     * @return              user's VO
     * @throws UserException        USR0012 Cannot find any user by this id param.
     * @throws RoleException        ROL0012 Cannot find any role by this id param.
     */
    UserVO update(UserParam param, User currentUser) throws UserException, RoleException;

    /**
     * Update user's password
     *
     * @param currentUser   current user
     * @param param         user's param
     * @throws UserException        USR0041 Update user's password failed.
     */
    void updatePwd(UserParam param, User currentUser) throws UserException;

    /**
     * Delete user.
     *
     * @param currentUser   current user
     * @param param         user's params
     * @throws UserException        USR0012 Cannot find any user by this id param.
     */
    void delete(UserParam param, User currentUser) throws UserException;

}
