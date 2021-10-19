package com.galaxy.system.service;

import java.util.Set;

public interface ISysRoleService {
    public Set<String> selectRoleKeys(Long userId);
}
