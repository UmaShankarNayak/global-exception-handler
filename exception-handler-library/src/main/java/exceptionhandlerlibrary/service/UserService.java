package exceptionhandlerlibrary.service;

import exceptionhandlerlibrary.dto.UserRecord;
import exceptionhandlerlibrary.exception.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Override
    public String save(UserRecord userRecord) {
        saveInDB(userRecord);
        return "Saved successfully into database...";

    }

    private void saveInDB(UserRecord userRecord) {
        //TODO saving into database...

        try {
            throw new ApiException(HttpStatus.BAD_GATEWAY,"DB connection is not available....");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
