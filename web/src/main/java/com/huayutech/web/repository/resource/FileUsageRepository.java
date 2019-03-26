package com.huayutech.web.repository.resource;

import com.huayutech.web.domain.resouce.File;
import com.huayutech.web.domain.resouce.FileUsage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileUsageRepository extends JpaRepository<FileUsage, Long> {

    Optional<FileUsage> findFirstByFileAndOwnerTypeAndOwnerId(File file, String ownerType, String ownerId);

}
