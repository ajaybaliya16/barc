package com.test_core.thingsboard.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.test_core.thingsboard.common.ThingsboardErrorCode;
import com.test_core.thingsboard.customException.ThingsboardException;
import com.test_core.thingsboard.entity.OSDataEntity;


public class DataUtils {
	 private static Map<Long, String> metaDataIdMap = new ConcurrentHashMap<>();
	    private static Map<Long, String> technicalConfigIdMap = new ConcurrentHashMap<>();
	    private static Map<String, Map<String, Long>> metaDataTypeMap = new ConcurrentHashMap<>();
	    private static Map<String, List<Map<String, Object>>> metaDataTypeMapList = new ConcurrentHashMap<>();
	    private static Map<Long, List<String>> osDataIdMap = new ConcurrentHashMap<>();
	    private static Map<String, List<Map<String, Object>>> osDataTypeMapList = new ConcurrentHashMap<>();
	    private static Map<String, List<Long>> osTypeOSTypeIdMap = new ConcurrentHashMap<>();
	    private static Map<String, Map<String, Long>> osTypeHWversionMap = new ConcurrentHashMap<>();
	    private static Map<String, Map<String, List<String>>> osHWversionMandatoryParamsMap = new ConcurrentHashMap<>();
	    private static Map<Long, List<String>> osHWversionConflictedComponentsMap = new ConcurrentHashMap<>();
	    private static Map<Integer, String> eventTypeMap = new ConcurrentHashMap<>();
	    //private static List<TechnicalConfig> technicalConfigList = new ArrayList<>();
	    private static List<String> eventListTypes = new ArrayList<>();
	    private static Map<String, List<String>> hwversionMandatoryParamsMap = new ConcurrentHashMap<>();
	    private static Map<String, List<String>> hwversionConflictedComponentsMap = new ConcurrentHashMap<>();
	    //private static Map<Integer, ChannelMapping> wmkIdChannelNameMap = new ConcurrentHashMap<>();
	    private static Map<String, Long> technicalConfigData = new ConcurrentHashMap<>();

	    public static Map<Integer, String> getEventTypeMap() {
	        return eventTypeMap;
	    }

	    public static List<String> getEventListTypes() {
	        return eventListTypes;
	    }

		/*
		 * public static List<TechnicalConfig> getTechnicalConfigs() { return
		 * technicalConfigList; }
		 */

	    public static Map<String, Map<String, Long>> getMetaData() {
	        return metaDataTypeMap;
	    }

	    public static Map<String, List<Map<String, Object>>> getMetaDataTypeMapList() {
	        return metaDataTypeMapList;
	    }

	    public static Map<String, List<Map<String, Object>>> getOsDataTypeMapList() {
	        return osDataTypeMapList;
	    }

	    public static Map<String, List<String>> getHWversionConflictedComponentsMap() {
	        return hwversionConflictedComponentsMap;
	    }

//	    public static Map<Integer, ChannelMapping> getwmkIdChannelNameMap() {
//	        return wmkIdChannelNameMap;
//	    }

	    public static Map<String, List<String>> getHWversionMandatoryParamsMap() {
	        return hwversionMandatoryParamsMap;
	    }

	    public static Long getMetaDataId(String type, String name) {
	        Long metaDataId = null;
	        if (metaDataTypeMap.containsKey(type)) {
	            Map<String, Long> typeMap = metaDataTypeMap.get(type);
	            if (typeMap.containsKey(name))
	                metaDataId = typeMap.get(name);
	        }
	        return metaDataId;
	    }

	    public static String getMetaDataName(Long metaDataId) {
	        String name = null;
	        if (metaDataIdMap.containsKey(metaDataId))
	            name = metaDataIdMap.get(metaDataId);
	        return name;
	    }

	    public static List<String> getMetaDataNameList(List<Long> metaDataIds) {
	        if (metaDataIds == null || metaDataIds.isEmpty())
	            return null;
	        List<String> name = new ArrayList<>();
	        for (long metaDataId : metaDataIds) {
	            if (metaDataIdMap.containsKey(metaDataId))
	                name.add(metaDataIdMap.get(metaDataId));
	        }
	        return name;
	    }

	    public static String getEventTypeById(Integer id) {
	        String name = null;
	        if (eventTypeMap.containsKey(id))
	            name = eventTypeMap.get(id);
	        return name;
	    }

	    public static Long getOsDataId(String osType, String hwVersion) {
	        Long id = null;
	        if (osTypeHWversionMap.containsKey(osType)) {
	            Map<String, Long> hwVersionMap = osTypeHWversionMap.get(osType);
	            if (hwVersionMap.containsKey(hwVersion))
	                id = hwVersionMap.get(hwVersion);
	        }
	        return id;
	    }

	    public static String getTechnicalConfigShortCode(Long id) {
	        String shortCode = null;
	        if (technicalConfigIdMap.containsKey(id))
	            shortCode = technicalConfigIdMap.get(id);
	        return shortCode;
	    }

	    public static Long getTechnicalConfigId(String shortCode) {
	        Long id = null;
	        if (technicalConfigData.containsKey(shortCode))
	            id = technicalConfigData.get(shortCode);
	        return id;
	    }

	    public static List<String> getOSTypeAndHwVersion(Long id) {
	        List<String> osTypeAndHwVersionList = null;
	        if (osDataIdMap.containsKey(id))
	            osTypeAndHwVersionList = osDataIdMap.get(id);
	        return osTypeAndHwVersionList;
	    }

	    public static List<String> getOsHWversionMandatoryParams(String osType, String hwVersion) {
	        List<String> mandatoryParams = null;
	        if (osHWversionMandatoryParamsMap.containsKey(osType)) {
	            Map<String, List<String>> hwVersionMap = osHWversionMandatoryParamsMap.get(osType);
	            if (hwVersionMap.containsKey(hwVersion))
	                mandatoryParams = hwVersionMap.get(hwVersion);
	        }
	        return mandatoryParams;
	    }

	    public static List<String> getOsHWversionConflictedComponents(Long id) {
	        List<String> conflictedComponents = null;
	        if (osHWversionConflictedComponentsMap.containsKey(id))
	            conflictedComponents = osHWversionConflictedComponentsMap.get(id);
	        return conflictedComponents;
	    }

	    public static List<Long> getOSTypeOSTypeIds(String osType) {
	        List<Long> osTYpeIds = null;
	        if (osTypeOSTypeIdMap.containsKey(osType))
	            osTYpeIds = osTypeOSTypeIdMap.get(osType);
	        return osTYpeIds;
	    }

//	    public static void init(List<MetaDataEntity> metaDataEntities, List<OSDataEntity> osDataEntities,
//	                            Map<Integer, String> eventMap, List<TechnicalConfig> technicalConfigs, List<WMKIdChannelNameEntity> wmkIdChannelNameEntities) {
//	        if (metaDataEntities != null && !metaDataEntities.isEmpty()) {
//	            getMetaDataTypeMapList(metaDataEntities);
//	            metaDataTypeMap = metaDataEntities.stream().collect(
//	                    java.util.stream.Collectors.groupingBy(MetaDataEntity::getType,
//	                            java.util.stream.Collectors.toMap(MetaDataEntity::getName, MetaDataEntity::getMetaDataId)));
//	            metaDataIdMap = metaDataEntities.stream().collect(
//	                    java.util.stream.Collectors.toMap(MetaDataEntity::getMetaDataId, MetaDataEntity::getName));
//	        }
//	        if (osDataEntities != null && !osDataEntities.isEmpty()) {
//	            getOsDataTypeMapList(osDataEntities);
//	            osDataIdMap = osDataEntities.stream().collect(
//	                    java.util.stream.Collectors.toMap(OSDataEntity::getId, osDataEntity -> {
//	                        List<String> list = new ArrayList<>();
//	                        list.add(osDataEntity.getOsType());
//	                        list.add(osDataEntity.getHardwareVersion());
//	                        return list;
//	                    }));
//	            osTypeHWversionMap = osDataEntities.stream().collect(
//	                    java.util.stream.Collectors.groupingBy(OSDataEntity::getOsType,
//	                            java.util.stream.Collectors.toMap(OSDataEntity::getHardwareVersion, OSDataEntity::getId)));
//	            osHWversionMandatoryParamsMap = osDataEntities.stream()
//	                    .filter(entity -> entity.getMandatoryParams() != null)
//	                    .collect(java.util.stream.Collectors.groupingBy(
//	                            OSDataEntity::getOsType,
//	                            java.util.stream.Collectors.toMap(
//	                                    OSDataEntity::getHardwareVersion,
//	                                    OSDataEntity::getMandatoryParams
//	                            )
//	                    ));
//	            osTypeOSTypeIdMap = osDataEntities.stream().collect(
//	                    java.util.stream.Collectors.groupingBy(
//	                            OSDataEntity::getOsType,
//	                            java.util.stream.Collectors.mapping(OSDataEntity::getId, java.util.stream.Collectors.toList())
//	                    )
//	            );
//	            hwversionMandatoryParamsMap = osDataEntities.stream()
//	                    .filter(entity -> entity.getMandatoryParams() != null)
//	                    .collect(java.util.stream.Collectors.toMap(
//	                            OSDataEntity::getHardwareVersion,
//	                            OSDataEntity::getMandatoryParams
//	                    ));
//	            osHWversionConflictedComponentsMap = osDataEntities.stream()
//	                    .filter(entity -> entity.getConflictedComponents() != null)
//	                    .collect(java.util.stream.Collectors.toMap(
//	                            OSDataEntity::getId,
//	                            OSDataEntity::getConflictedComponents
//	                    ));
//	            hwversionConflictedComponentsMap = osDataEntities.stream()
//	                    .filter(entity -> entity.getConflictedComponents() != null)
//	                    .collect(java.util.stream.Collectors.toMap(
//	                            OSDataEntity::getHardwareVersion,
//	                            OSDataEntity::getConflictedComponents
//	                    ));
//	        }
//	        if (eventMap != null && !eventMap.isEmpty()) {
//	            eventTypeMap = eventMap;
//	            eventListTypes = eventMap.entrySet().stream().map(a -> a.getValue()).collect(Collectors.toList());
//	        }
//	        if (technicalConfigs != null && !technicalConfigs.isEmpty()) {
//	            technicalConfigList = technicalConfigs;
//	            technicalConfigData = technicalConfigs.stream().collect(
//	                    java.util.stream.Collectors.toMap(TechnicalConfig::getShortCode, TechnicalConfig::getId));
//	            technicalConfigIdMap = technicalConfigs.stream().collect(
//	                    java.util.stream.Collectors.toMap(TechnicalConfig::getId, TechnicalConfig::getShortCode));
//	        }
//	        if (wmkIdChannelNameEntities != null && !wmkIdChannelNameEntities.isEmpty())
//	            wmkIdChannelNameMap = wmkIdChannelNameEntities.stream()
//	                    .filter(entity -> entity.getWatermarkId() != null)
//	                    .collect(java.util.stream.Collectors.toMap(
//	                            WMKIdChannelNameEntity::getWatermarkId,
//	                            entity -> new ChannelMapping(entity.getChannelCode(), entity.getChannelName())
//	                    ));
//	    }
	    
	    private static void getOsDataTypeMapList(List<OSDataEntity> osDataEntities) {
	        osDataTypeMapList.clear();
	        for (OSDataEntity osDataEntity : osDataEntities) {
	            if (osDataTypeMapList.containsKey(osDataEntity.getOsType())) {
	                List<Map<String, Object>> list = osDataTypeMapList.get(osDataEntity.getOsType());
	                Map<String, Object> map = new ConcurrentHashMap<>();
	                map.put("name", osDataEntity.getHardwareVersion());
	                map.put("id", osDataEntity.getId());
	                list.add(map);
	            } else {
	                List<Map<String, Object>> list = new java.util.ArrayList<>();
	                Map<String, Object> map = new ConcurrentHashMap<>();
	                map.put("name", osDataEntity.getHardwareVersion());
	                map.put("id", osDataEntity.getId());
	                list.add(map);
	                osDataTypeMapList.put(osDataEntity.getOsType(), list);
	            }
	        }
	    }

//	    private static void getMetaDataTypeMapList(List<MetaDataEntity> metaDataEntities) {
//	        metaDataTypeMapList.clear();
//	        for (MetaDataEntity metaDataEntity : metaDataEntities) {
//	            if (metaDataTypeMapList.containsKey(metaDataEntity.getType())) {
//	                List<Map<String, Object>> list = metaDataTypeMapList.get(metaDataEntity.getType());
//	                Map<String, Object> map = new ConcurrentHashMap<>();
//	                map.put("name", metaDataEntity.getName());
//	                map.put("id", metaDataEntity.getMetaDataId());
//	                list.add(map);
//	            } else {
//	                List<Map<String, Object>> list = new java.util.ArrayList<>();
//	                Map<String, Object> map = new ConcurrentHashMap<>();
//	                map.put("name", metaDataEntity.getName());
//	                map.put("id", metaDataEntity.getMetaDataId());
//	                list.add(map);
//	                metaDataTypeMapList.put(metaDataEntity.getType(), list);
//	            }
//	        }
//
//	    }
	    public static Long getOsTypeDataId(String osType, String hwVersion) throws ThingsboardException {
	        Long id = getOsDataId(osType, hwVersion);
	        if (id == null)
	            throw new ThingsboardException("Invalid OSType or Hardware Version", ThingsboardErrorCode.INVALID_ARGUMENTS);
	        return id;
	    }

	    public static String getMeterType(String meterType) {
	        if (meterType != null) {
	            try {
	                meterType = (getMetaDataName(Long.valueOf(meterType)));
	            } catch (NumberFormatException e) {
	            }
	        }
	        return meterType;
	    }

//	    public static RawMeterEvent fromByteArray(byte[] bytes) throws IOException, ClassNotFoundException {
//	        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
//	             ObjectInputStream ois = new ObjectInputStream(bis)) {
//	            return (RawMeterEvent) ois.readObject();
//	        }
//	    }
}