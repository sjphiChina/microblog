/**
 * 
 */
package sjph.life.model.user.dao;

import sjph.life.model.user.User;

/**
 * @author shaoguo
 *
 */
public interface UserDao {

    /**
     * @param user
     * @return
     */
    int createUser(User user);

    /**
     * @param id
     * @return
     */
    int deleteUser(Long id);

    /**
     * @param id
     * @return
     */
    User findUser(Long id);

    /**
     * @param user
     * @return
     */
    User updateUser(User user);
}
