package com.test_core.thingsboard.repo;


import java.awt.print.Pageable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test_core.thingsboard.entity.MeterEntity;

public interface MeterRepository extends JpaRepository<MeterEntity, Long> {
    
	MeterEntity findByMeterId(Long meterId);

//    @Query("SELECT COUNT(*) as ct, " +
//            "SUM(CASE WHEN m.statusId = 16 THEN 1 ELSE 0 END) AS standByCt, " +
//            "SUM(CASE WHEN m.statusId = 15 THEN 1 ELSE 0 END) AS installedCt, " +
//            "SUM(CASE WHEN m.statusId = 17 THEN 1 ELSE 0 END) AS uninstallationInProgressCt, " +
//            "SUM(CASE WHEN m.statusId = 13 THEN 1 ELSE 0 END) AS unaccountedCt, " +
//            "SUM(CASE WHEN m.statusId = 24 THEN 1 ELSE 0 END) AS installtionInProgressCt, " +
//            "SUM(CASE WHEN m.statusId = 14 THEN 1 ELSE 0 END) AS inServicingCt, " +
//            "SUM(CASE WHEN m.statusId = 18 THEN 1 ELSE 0 END) AS retiredCt " +
//            "FROM MeterEntity m " +
//            "JOIN OSDataEntity os ON os.id = m.osTypeId " +
//            "WHERE m.statusId IS NOT NULL " +
//            "AND (:osType IS NULL OR os.osType = :osType) " +
//            "AND (:hardwareVersion IS NULL OR os.id = :hardwareVersion) " +
//            "AND (cast(:productionDateFrom as timestamp) IS NULL OR m.updatedTime >= cast(:productionDateFrom as timestamp)) " +
//            "AND (cast(:productionDateTo as timestamp) IS NULL OR m.updatedTime <= cast(:productionDateTo as timestamp)) ")
//    Map<String, Long> findMeterSummary(@Param("osType") String osType, @Param("hardwareVersion") Long hardwareVersion,
//                                       @Param("productionDateFrom") Timestamp productionDateFrom,
//                                       @Param("productionDateTo") Timestamp productionDateTo);
//
//    @Query("SELECT new MeterEntity(m, s, sd, t.statusId AS teststatusId) " +
//            "FROM MeterEntity m " +
//            "JOIN OSDataEntity os ON os.id = m.osTypeId " +
//            "JOIN MetaDataEntity md ON m.statusId = md.metaDataId " +
//            "LEFT JOIN TestReportEntity t ON t.meterId = m.meterId " +
//            "LEFT JOIN MetaDataEntity md1 ON t.statusId = md1.metaDataId " +
//            "LEFT JOIN SimDataEntity s ON s.id = m.sim1ImsiId " +
//            "LEFT JOIN MetaDataEntity md2 ON s.serviceProviderId = md2.metaDataId " +
//            "LEFT JOIN SimDataEntity sd ON sd.id = m.sim2ImsiId " +
//            "LEFT JOIN MetaDataEntity md3 ON sd.serviceProviderId = md3.metaDataId " +
//            "WHERE (:meterId IS NULL OR m.meterId = :meterId) " +
//            "AND (COALESCE(:meterIds) IS NULL OR m.meterId in :meterIds) " +
//            "AND (:meterIdFrom IS NULL OR m.meterId >= :meterIdFrom) " +
//            "AND (:meterIdTo IS NULL OR m.meterId <= :meterIdTo) " +
//            "AND (:hardwareVersion IS NULL OR os.id = :hardwareVersion) " +
//            "AND (COALESCE(:hardwareVersions) IS NULL OR os.id in :hardwareVersions) " +
//            "AND (:imeiBaseboardSerialNo IS NULL OR m.imeiBaseboardSerialNo = :imeiBaseboardSerialNo) " +
//            "AND (:sim1Provider IS NULL OR md2.id = :sim1Provider) " +
//            "AND (:sim2Provider IS NULL OR md3.id = :sim2Provider) " +
//            "AND (:statusId IS NULL OR m.statusId = :statusId) " +
//            "AND (COALESCE(:statusIds) IS NULL OR m.statusId in :statusIds) " +
//            "AND (:motherboardSerialNo IS NULL OR m.motherboardSerialNo = :motherboardSerialNo) " +
//            "AND (:meterType IS NULL OR os.osType = :meterType) " +
//            "AND (COALESCE(:meterTypes) IS NULL OR os.osType IN :meterTypes) " +
//            "AND (cast(:productionDateFrom as timestamp) IS NULL OR m.productionDate >= cast(:productionDateFrom as timestamp)) " +
//            "AND (cast(:productionDateTo as timestamp) IS NULL OR m.productionDate <= cast(:productionDateTo as timestamp))" +
//            "AND (cast(:validFrom as timestamp) IS NULL OR m.updatedTime >= cast(:validFrom as timestamp)) " +
//            "AND (cast(:validTo as timestamp) IS NULL OR m.updatedTime <= cast(:validTo as timestamp)) " +
//            "AND (:teststatusId IS NULL OR t.statusId = :teststatusId) " +
//            "AND (COALESCE(:teststatusIds) IS NULL OR t.statusId in :teststatusIds)")
//    Page<MeterEntity> findMeter(@Param("meterId") Long meterId,
//                                @Param("meterIds") List<Long> meterIds,
//                                @Param("meterIdFrom") Long meterIdFrom,
//                                @Param("meterIdTo") Long meterIdTo,
//                                @Param("statusId") Long statusId,
//                                @Param("statusIds") List<Long> statusIds,
//                                @Param("meterType") String meterType,
//                                @Param("meterTypes") List<String> meterTypes,
//                                @Param("hardwareVersion") Long hardwareVersion,
//                                @Param("hardwareVersions") List<Long> hardwareVersions,
//                                @Param("productionDateFrom") Timestamp productionDateFrom,
//                                @Param("productionDateTo") Timestamp productionDateTo,
//                                @Param("sim1Provider") Long sim1Provider,
//                                @Param("imeiBaseboardSerialNo") String imeiBaseboardSerialNo,
//                                @Param("validFrom") Timestamp validFrom,
//                                @Param("validTo") Timestamp validTo,
//                                @Param("teststatusId") Long teststatusId,
//                                @Param("teststatusIds") List<Long> teststatusIds,
//                                @Param("sim2Provider") Long sim2Provider,
//                                @Param("motherboardSerialNo") String motherboardSerialNo,
//                                Pageable pageable);

//    @Query("SELECT m.statusId,  m.osTypeId, m.lastConnectedDate, s.serviceProviderId, sd.serviceProviderId " +
//            "FROM MeterEntity m " +
//            "LEFT JOIN SimDataEntity s ON s.id = m.sim1ImsiId " +
//            "LEFT JOIN MetaDataEntity md ON s.serviceProviderId = md.metaDataId " +
//            "LEFT JOIN SimDataEntity sd ON sd.id = m.sim2ImsiId " +
//            "LEFT JOIN MetaDataEntity md1 ON sd.serviceProviderId = md1.metaDataId " +
//            "WHERE (:meterId IS NULL OR m.meterId = :meterId) ")
//    List<List> findMeterData(@Param("meterId") Long meterId);

    @Query(value = "SELECT DISTINCT m.meterId FROM MeterEntity m ")
    List<Long> getMeterIds();

//    @Query("SELECT m FROM MeterEntity m " +
//            " JOIN OSDataEntity os ON m.osTypeId = os.id " +
//            " JOIN MetaDataEntity md ON m.statusId = md.metaDataId " +
//            "WHERE ((:motherboardSNo IS NOT NULL AND m.motherboardSerialNo = :motherboardSNo) " +
//            "   OR (:imeiBaseboardSNo IS NOT NULL AND m.imeiBaseboardSerialNo = :imeiBaseboardSNo) " +
//            "   OR (:powerpcbSNo IS NOT NULL AND m.powerPcbSerialNo = :powerpcbSNo) " +
//            "   OR (:ethernetMac IS NOT NULL AND m.ethernetMac = :ethernetMac) " +
//            "   OR (:bleAddress IS NOT NULL AND m.bleAddress = :bleAddress) " +
//            "   OR (:wifiMac IS NOT NULL AND m.wifiMac = :wifiMac))" +
//            "   AND m.meterId != :meterId" +
//            "   AND md.name !='IN_SERVICING'")
//    List<MeterEntity> findConflictedComponent(@Param("motherboardSNo") String motherboardSNo,
//                                              @Param("imeiBaseboardSNo") String imeiBaseboardSNo,
//                                              @Param("powerpcbSNo") String powerpcbSNo,
//                                              @Param("ethernetMac") String ethernetMac,
//                                              @Param("bleAddress") String bleAddress,
//                                              @Param("wifiMac") String wifiMac,
//                                              @Param("meterId") Long meterId);

//    @Query("SELECT m.meterId FROM MeterEntity m " +
//            " WHERE (COALESCE(:meterIds) IS NULL OR m.meterId in :meterIds) ")
//    List<Long> findValidMeterIds(@Param("meterIds") List<Long> meterIds);

//    @Query("SELECT m.meterId FROM MeterEntity m WHERE m.meterId >= :start AND m.meterId <= :end")
//    List<Long> findMetersByMeterIdRange(@Param("start") long start, @Param("end") long end);

//    @Query("SELECT MAX(m.meterId) FROM MeterEntity m WHERE m.meterId >= :startMeterId AND m.meterId <= :endMeterId")
//    Long findMaxMeterIdInRange(@Param("startMeterId") Long startMeterId,
//                               @Param("endMeterId") Long endMeterId);

    MeterEntity findByDeviceId(String deviceId);

    @Query("SELECT m.kLicenceKey FROM MeterEntity m WHERE m.deviceId = :deviceId")
    String findLicensekeyByDeviceId(@Param("deviceId") String deviceID);

//    @Query("SELECT m.lastConnectedDate FROM MeterEntity m WHERE m.meterId = :meterId")
//    Timestamp findLastConnectedTimeByMeterId(@Param("meterId") Long meterId);

//    @Query("SELECT m.statusId FROM MeterEntity m WHERE m.meterId = :meterId")
//    Long findMeterIdStatus(@Param("meterId") Long meterId);

//    @Query("SELECT m, ai.tvId, h.hhid,h.memberNames, os.hardwareVersion, s1.simSerial, md.name  FROM MeterEntity m " +
//            "JOIN AssetInstallationEntity ai ON ai.meterId = m.meterId " +
//            "JOIN HouseHoldEntity h ON h.hhid = ai.hhid " +
//            "JOIN OSDataEntity os ON os.id = m.osTypeId " +
//            "LEFT JOIN SimDataEntity s1 ON m.sim1ImsiId = s1.id " +
//            "LEFT JOIN MetaDataEntity md ON s1.serviceProviderId = md.metaDataId " +
//            "WHERE m.meterId = :meterId " +
//            "AND m.statusId IN (15,24) " +
//            "ORDER BY ai.id DESC")
//    List<Object[]> findLatestMeterMembersdata(@Param("meterId") Long meterId);

//    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN TRUE ELSE FALSE END FROM MeterEntity m WHERE m.meterId = :meterId")
//    boolean existsByMeterId(@Param("meterId") Long meterId);
//
    @Query("SELECT m FROM MeterEntity m WHERE m.sim1ImsiId = :simImsiId OR m.sim2ImsiId =:simImsiId")
    MeterEntity findByImsiId(@Param("simImsiId") Long simImsiId);

//    @Query("SELECT m.lastEventId FROM MeterEntity m WHERE m.meterId = :meterId")
//    Long findLastEventIdByMeterId(@Param("meterId") Long meterId);
}
