package com.test_core.thingsboard.dao;


import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.swing.SortOrder;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.util.CollectionUtils;
//import org.thingsboard.server.common.data.EntityInfo;
//import org.thingsboard.server.common.data.EntitySubtype;
//import org.thingsboard.server.common.data.EntityType;
//import org.thingsboard.server.common.data.id.TenantId;
//import org.thingsboard.server.common.data.id.UUIDBased;
//import org.thingsboard.server.common.data.page.PageData;
//import org.thingsboard.server.common.data.page.PageLink;
//import org.thingsboard.server.dao.model.ToData;

public abstract class DaoUtil {

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
