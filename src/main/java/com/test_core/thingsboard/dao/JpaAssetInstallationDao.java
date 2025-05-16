package com.test_core.thingsboard.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaAssetInstallationDao implements AssetInstallationDao {

	@Autowired
	private AssetInstallationRepository assetInstallationRepository;

	public Long getHouseHoldIdByMeterId(Long meterId) {
		return assetInstallationRepository.getHouseHoldIdByMeterId(meterId);
	}
}
