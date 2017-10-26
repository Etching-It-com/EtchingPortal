
package com.EtchingPortal.dao;


import java.util.List;

import com.EtchingPortal.domain.Profile;

public interface ProfileDAO {

    public Profile viewProfile(int id);

    public Profile editProfile(Profile job);

    public List<Profile> searchProfileByText(String text);
}
