package com.test_core.thingsboard.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class DaoUtil {

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

    public static Map<String, List<String>> getHWversionMandatoryParamsMap() {
        return hwversionMandatoryParamsMap;
    }

	private DaoUtil() {
	}

//    public static <T> PageData<T> toPageData(Page<? extends ToData<T>> page) {
//        List<T> data = convertDataList(page.getContent());
//        return new PageData<>(data, page.getTotalPages(), page.getTotalElements(), page.hasNext());
//    }
//
//    public static <T> PageData<T> pageToPageData(Page<T> page) {
//        return new PageData<>(page.getContent(), page.getTotalPages(), page.getTotalElements(), page.hasNext());
//    }
//
//    public static Pageable toPageable(PageLink pageLink) {
//        return toPageable(pageLink, Collections.emptyMap());
//    }
//
//    public static Pageable toPageable(PageLink pageLink, Map<String, String> columnMap) {
//        return PageRequest.of(pageLink.getPage(), pageLink.getPageSize(), pageLink.toSort(pageLink.getSortOrder(), columnMap));
//    }
//
//    public static Pageable toPageable(PageLink pageLink, List<SortOrder> sortOrders) {
//        return toPageable(pageLink, Collections.emptyMap(), sortOrders);
//    }
//
//    public static Pageable toPageable(PageLink pageLink, Map<String, String> columnMap, List<SortOrder> sortOrders) {
//        return PageRequest.of(pageLink.getPage(), pageLink.getPageSize(), pageLink.toSort(sortOrders, columnMap));
//    }

	public static <T> List<T> convertDataList(Collection<? extends ToData<T>> toDataList) {
		List<T> list = Collections.emptyList();
		if (toDataList != null && !toDataList.isEmpty()) {
			list = new ArrayList<>();
			for (ToData<T> object : toDataList) {
				if (object != null) {
					list.add(object.toData());
				}
			}
		}
		return list;
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

	public static <T> T getData(ToData<T> data) {
		T object = null;
		if (data != null) {
			object = data.toData();
		}
		return object;
	}

//    public static <T> T getData(Optional<? extends ToData<T>> data) {
//        T object = null;
//        if (data.isPresent()) {
//            object = data.get().toData();
//        }
//        return object;
//    }
//
//    public static UUID getId(UUIDBased idBased) {
//        UUID id = null;
//        if (idBased != null) {
//            id = idBased.getId();
//        }
//        return id;
//    }
//
//    public static List<UUID> toUUIDs(List<? extends UUIDBased> idBasedIds) {
//        List<UUID> ids = new ArrayList<>();
//        for (UUIDBased idBased : idBasedIds) {
//            ids.add(getId(idBased));
//        }
//        return ids;
//    }
//
//    public static <I> List<I> fromUUIDs(List<UUID> uuids, Function<UUID, I> mapper) {
//        return uuids.stream().map(mapper).collect(Collectors.toList());
//    }
//
//    public static <I> I toEntityId(UUID uuid, Function<UUID, I> creator) {
//        if (uuid != null) {
//            return creator.apply(uuid);
//        } else {
//            return null;
//        }
//    }
//
//    public static <T> void processInBatches(Function<PageLink, PageData<T>> finder, int batchSize, Consumer<T> processor) {
//        processBatches(finder, batchSize, batch -> batch.getData().forEach(processor));
//    }
//
//    public static <T> void processBatches(Function<PageLink, PageData<T>> finder, int batchSize, Consumer<PageData<T>> processor) {
//        PageLink pageLink = new PageLink(batchSize);
//        PageData<T> batch;
//
//        boolean hasNextBatch;
//        do {
//            batch = finder.apply(pageLink);
//            processor.accept(batch);
//
//            hasNextBatch = batch.hasNext();
//            pageLink = pageLink.nextPageLink();
//        } while (hasNextBatch);
//    }
//
//    public static String getStringId(UUIDBased id) {
//        if (id != null) {
//            return id.toString();
//        } else {
//            return null;
//        }
//    }
//
//    public static List<EntitySubtype> convertTenantEntityTypesToDto(UUID tenantUUID, EntityType entityType, List<String> types) {
//        if (CollectionUtils.isEmpty(types)) {
//            return Collections.emptyList();
//        }
//        TenantId tenantId = TenantId.fromUUID(tenantUUID);
//        return types.stream()
//                .map(type -> new EntitySubtype(tenantId, entityType, type))
//                .collect(Collectors.toList());
//    }
//
//    @Deprecated // used only in deprecated DAO api
//    public static List<EntitySubtype> convertTenantEntityInfosToDto(UUID tenantUUID, EntityType entityType, List<EntityInfo> entityInfos) {
//        if (CollectionUtils.isEmpty(entityInfos)) {
//            return Collections.emptyList();
//        }
//        var tenantId = TenantId.fromUUID(tenantUUID);
//        return entityInfos.stream()
//                .map(info -> new EntitySubtype(tenantId, entityType, info.getName()))
//                .sorted(Comparator.comparing(EntitySubtype::getType))
//                .collect(Collectors.toList());
//    }

}
