package kg.peaksoftlms.peaksoftlms.service;

import kg.peaksoftlms.peaksoftlms.db.model.Role;

public interface RoleService {
    Role getByRoleName(String roleName);
}
