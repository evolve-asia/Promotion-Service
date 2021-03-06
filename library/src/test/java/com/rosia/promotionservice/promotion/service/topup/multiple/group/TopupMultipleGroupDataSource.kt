package com.rosia.promotionservice.promotion.service.topup.multiple.group

import com.rosia.promotionservice.promotion.data.ApplicableSkuLocalModel
import com.rosia.promotionservice.promotion.data.PromotionModel
import com.rosia.promotionservice.promotion.data.PromotionSkuGroupModel
import com.rosia.promotionservice.promotion.data.PromotionSkuModel
import com.rosia.promotionservice.promotion.data.SkuBatchModel
import com.rosia.promotionservice.promotion.data.SkuFamilyCriteriaModel
import com.rosia.promotionservice.promotion.service.PromotionConstant
import com.rosia.promotionservice.promotion.service.bill.criteria.operator.OperatorConstants

object TopupMultipleGroupDataSource {

    private fun getFakeGroupPromotionSkuModel(
        quantity: Int,
        isSelected: Boolean = true,
        skuId: Long = 1
    ): PromotionSkuModel {
        return PromotionSkuModel(
            skuId = skuId,
            skuName = "Buy 200 Pcs of Vicks Vaporub - 5 gm and get 2% off",
            brandName = "Vicks",
            moq = 2,
            quantity = quantity,
            promotionStatus = true,
            inStock = true,
            batchList = listOf(
                SkuBatchModel(
                    id = 1,
                    rlpVat = 11.30,
                    batchTitle = "First",
                    isSelected = isSelected,
                    rlp = 10.0,
                    vatPercent = 0.13
                )
            ),
            discountAmount = 0.0,
            grossAmount = 10.0 * quantity,
            netAmount = 11.3 * quantity,
            vatAmount = 1.3 * quantity,
            taxableAmount = 10.0 * quantity,
            orderId = 1,
            topUpDiscount = 0.0,
            stockQty = 10
        )
    }

    private fun getFakeApplicableSkuModelWithAmountCriteria(
        skuId: Long,
        skuGroupId: Int = 1,
        familyMinMax: Int = 2500,
        groupMinMax: Int = 3000,
        groupSkuIds: String = "1,2,3"
    ): ApplicableSkuLocalModel {
        return ApplicableSkuLocalModel(
            skuId = skuId,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 0,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 0,
            skuGroupId = skuGroupId,
            familyStatus = true,
            familyId = -1,
            skuFamilyCriteriaModel = SkuFamilyCriteriaModel(
                familyId = 1,
                promotionId = 1,
                type = PromotionConstant.CRITERIA_AMOUNT,
                maxType = OperatorConstants.GREATER_THAN_EQUALS,
                maxValue = familyMinMax,
                minType = OperatorConstants.GREATER_THAN_EQUALS,
                minValue = familyMinMax,
                skuCount = 0,
                allowMultiple = false
            ),
            groupCriteriaLocalModel = PromotionSkuGroupModel(
                id = 1,
                promotionId = 1,
                skuIds = groupSkuIds,
                type = PromotionConstant.CRITERIA_AMOUNT,
                maxType = OperatorConstants.GREATER_THAN_EQUALS,
                maxValue = groupMinMax,
                minType = OperatorConstants.GREATER_THAN_EQUALS,
                minValue = groupMinMax,
                skuCount = 0,
                allowMultiple = false

            )
        )
    }

    private fun getFakeApplicableSkuModelWithQuantityCriteria(
        skuId: Long,
        skuGroupId: Int = 1,
        familyMinMax: Int = 2500,
        groupMinMax: Int = 3000,
        groupSkuIds: String = "1,2,3"
    ): ApplicableSkuLocalModel {
        return ApplicableSkuLocalModel(
            skuId = skuId,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 0,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 0,
            skuGroupId = skuGroupId,
            familyStatus = true,
            familyId = -1,
            skuFamilyCriteriaModel = SkuFamilyCriteriaModel(
                familyId = 1,
                promotionId = 1,
                type = PromotionConstant.CRITERIA_QUANTITY,
                maxType = OperatorConstants.GREATER_THAN_EQUALS,
                maxValue = familyMinMax,
                minType = OperatorConstants.GREATER_THAN_EQUALS,
                minValue = familyMinMax,
                skuCount = 0,
                allowMultiple = false
            ),
            groupCriteriaLocalModel = PromotionSkuGroupModel(
                id = 1,
                promotionId = 1,
                skuIds = groupSkuIds,
                type = PromotionConstant.CRITERIA_QUANTITY,
                maxType = OperatorConstants.GREATER_THAN_EQUALS,
                maxValue = groupMinMax,
                minType = OperatorConstants.GREATER_THAN_EQUALS,
                minValue = groupMinMax,
                skuCount = 0,
                allowMultiple = false

            )
        )
    }

    fun get_amount_amount_success(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy products of 2 diff group worth 2000 and get 10 rsoff",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 1, familyMinMax = 2500, groupMinMax = 3000),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 2, familyMinMax = 2500, groupMinMax = 3000),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 3, familyMinMax = 2500, groupMinMax = 3000)

            ),
            skuList = listOf(
                getFakeGroupPromotionSkuModel(quantity = 50, skuId = 1),
                getFakeGroupPromotionSkuModel(quantity = 50, skuId = 2),
                getFakeGroupPromotionSkuModel(quantity = 200, skuId = 3)
            )
        )
    }

    fun get_amount_amount_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy products of 2 diff group worth 2000 and get 100 rsoff",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 0.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 1, familyMinMax = 2500, groupMinMax = 3000),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 2, familyMinMax = 2500, groupMinMax = 3000),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 3, familyMinMax = 2500, groupMinMax = 3000)

            ),
            skuList = listOf(
                getFakeGroupPromotionSkuModel(quantity = 10, skuId = 1),
                getFakeGroupPromotionSkuModel(quantity = 50, skuId = 2),
                getFakeGroupPromotionSkuModel(quantity = 200, skuId = 3)
            )
        )
    }

    fun get_amount_percent_success(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy products of 2 diff family worth 2000 and get 10% off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 1, familyMinMax = 2500, groupMinMax = 3000),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 2, familyMinMax = 2500, groupMinMax = 3000),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 3, familyMinMax = 2500, groupMinMax = 3000)

            ),
            skuList = listOf(
                getFakeGroupPromotionSkuModel(quantity = 50, skuId = 1),
                getFakeGroupPromotionSkuModel(quantity = 50, skuId = 2),
                getFakeGroupPromotionSkuModel(quantity = 200, skuId = 3)
            )
        )
    }

    fun get_amount_percent_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy products of 2 diff family worth 2000 and get 10% off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 1, familyMinMax = 2500, groupMinMax = 3000),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 2, familyMinMax = 2500, groupMinMax = 3000),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 3, familyMinMax = 2500, groupMinMax = 3000)

            ),
            skuList = listOf(
                getFakeGroupPromotionSkuModel(quantity = 10, skuId = 1),
                getFakeGroupPromotionSkuModel(quantity = 50, skuId = 2),
                getFakeGroupPromotionSkuModel(quantity = 200, skuId = 3)
            )
        )
    }

    fun get_amount_sku_success(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy products of 2 diff family worth 2000 and get 1 for free",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_FREE_SKU,
            disbursementValue = 1.0,
            applicableSkuIds = "1,2",
            allowMultiple = false,
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 1, familyMinMax = 2500, groupMinMax = 3000),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 2, familyMinMax = 2500, groupMinMax = 3000),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 3, familyMinMax = 2500, groupMinMax = 3000)

            ),
            skuList = listOf(
                getFakeGroupPromotionSkuModel(quantity = 50, skuId = 1),
                getFakeGroupPromotionSkuModel(quantity = 50, skuId = 2),
                getFakeGroupPromotionSkuModel(quantity = 200, skuId = 3)
            )
        )
    }

    fun get_amount_sku_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy products of 2 diff family worth 2000 and get 1 for free",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_AMOUNT,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 2000,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 2000,
            skuCount = 1,
            disbursementType = PromotionConstant.DISBURSEMENT_FREE_SKU,
            disbursementValue = 1.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 1, familyMinMax = 2500, groupMinMax = 3000),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 2, familyMinMax = 2500, groupMinMax = 3000),
                getFakeApplicableSkuModelWithAmountCriteria(skuId = 3, familyMinMax = 2500, groupMinMax = 3000)

            ),
            skuList = listOf(
                getFakeGroupPromotionSkuModel(quantity = 10, skuId = 1),
                getFakeGroupPromotionSkuModel(quantity = 50, skuId = 2),
                getFakeGroupPromotionSkuModel(quantity = 200, skuId = 3)
            )
        )
    }

    fun get_quantity_amount_success(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 10 of 2 diff group and get 10 rsoff",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 10,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 10,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 1, familyMinMax = 15, groupMinMax = 20),
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 2, familyMinMax = 15, groupMinMax = 20),
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 3, familyMinMax = 15, groupMinMax = 20)

            ),
            skuList = listOf(
                getFakeGroupPromotionSkuModel(quantity = 5, skuId = 1),
                getFakeGroupPromotionSkuModel(quantity = 5, skuId = 2),
                getFakeGroupPromotionSkuModel(quantity = 11, skuId = 3)
            )
        )
    }

    fun get_quantity_amount_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 10 of 2 diff group and get 10 rsoff",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 10,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 10,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_AMOUNT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 1, familyMinMax = 15, groupMinMax = 20),
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 2, familyMinMax = 15, groupMinMax = 20),
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 3, familyMinMax = 15, groupMinMax = 20)

            ),
            skuList = listOf(
                getFakeGroupPromotionSkuModel(quantity = 5, skuId = 1),
                getFakeGroupPromotionSkuModel(quantity = 5, skuId = 2),
                getFakeGroupPromotionSkuModel(quantity = 6, skuId = 3)
            )
        )
    }

    fun get_quantity_percent_success(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 10 pcs of 2 diff group and get 10 % off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 10,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 10,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            allowMultiple = false,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 1, familyMinMax = 15, groupMinMax = 20),
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 2, familyMinMax = 15, groupMinMax = 20),
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 3, familyMinMax = 15, groupMinMax = 20)

            ),
            skuList = listOf(
                getFakeGroupPromotionSkuModel(quantity = 5, skuId = 1),
                getFakeGroupPromotionSkuModel(quantity = 5, skuId = 2),
                getFakeGroupPromotionSkuModel(quantity = 11, skuId = 3)
            )
        )
    }

    fun get_quantity_percent_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 10 pcs of 2 diff group and get 10 % off",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 10,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 10,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_PERCENT,
            disbursementValue = 10.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            allowMultiple = false,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 1, familyMinMax = 15, groupMinMax = 20),
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 2, familyMinMax = 15, groupMinMax = 20),
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 3, familyMinMax = 15, groupMinMax = 20)

            ),
            skuList = listOf(
                getFakeGroupPromotionSkuModel(quantity = 5, skuId = 1),
                getFakeGroupPromotionSkuModel(quantity = 5, skuId = 2),
                getFakeGroupPromotionSkuModel(quantity = 6, skuId = 3)
            )
        )
    }

    fun get_quantity_sku_success(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 10 pcs of 2 diff family and get 1 sku free",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 10,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 10,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_FREE_SKU,
            disbursementValue = 1.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            allowMultiple = false,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 1, familyMinMax = 15, groupMinMax = 20),
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 2, familyMinMax = 15, groupMinMax = 20),
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 3, familyMinMax = 15, groupMinMax = 20)

            ),
            skuList = listOf(
                getFakeGroupPromotionSkuModel(quantity = 5, skuId = 1),
                getFakeGroupPromotionSkuModel(quantity = 5, skuId = 2),
                getFakeGroupPromotionSkuModel(quantity = 11, skuId = 3)
            )
        )
    }

    fun get_quantity_sku_error(): PromotionModel {
        return PromotionModel(
            promotionId = 1,
            title = "Buy 10 pcs of 2 diff family and get 1 sku free",
            promotionState = PromotionConstant.MULTIPLE_PROMOTION,
            criteriaId = 1,
            criteriaType = PromotionConstant.CRITERIA_QUANTITY,
            criteriaMaxOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMaxValue = 10,
            criteriaMinOpr = OperatorConstants.GREATER_THAN_EQUALS,
            criteriaMinValue = 10,
            skuCount = 0,
            disbursementType = PromotionConstant.DISBURSEMENT_FREE_SKU,
            disbursementValue = 1.0,
            applicableSkuIds = "1,2",
            promotionType = PromotionConstant.PROMOTION_TYPE_TOP_UP,
            allowMultiple = false,
            applicableSkuModelList = listOf(
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 1, familyMinMax = 15, groupMinMax = 20),
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 2, familyMinMax = 15, groupMinMax = 20),
                getFakeApplicableSkuModelWithQuantityCriteria(skuId = 3, familyMinMax = 15, groupMinMax = 20)

            ),
            skuList = listOf(
                getFakeGroupPromotionSkuModel(quantity = 5, skuId = 1),
                getFakeGroupPromotionSkuModel(quantity = 5, skuId = 2),
                getFakeGroupPromotionSkuModel(quantity = 6, skuId = 3)
            )
        )
    }
}