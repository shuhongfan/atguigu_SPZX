package com.atguigu.spzx.model.entity.order;

import com.atguigu.spzx.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Schema(description = "OrderInfo")
public class OrderInfo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Schema(description = "会员_id")
	private Long userId;

	@Schema(description = "昵称")
	private String nickName;

	@Schema(description = "订单号")
	private String orderNo;

	@Schema(description = "使用的优惠券")
	private Long couponId;

	@Schema(description = "订单总额")
	private BigDecimal totalAmount;

	@Schema(description = "优惠券")
	private BigDecimal couponAmount;

	@Schema(description = "原价金额")
	private BigDecimal originalTotalAmount;

	@Schema(description = "运费")
	private BigDecimal feightFee;

	@Schema(description = "支付方式【1->微信】")
	private Integer payType;

	@Schema(description = "订单状态【0->待付款；1->待发货；2->已发货；3->待用户收货，已完成；-1->已取消】")
	private Integer orderStatus;

	@Schema(description = "收货人姓名")
	private String receiverName;

	@Schema(description = "收货人电话")
	private String receiverPhone;

	@Schema(description = "收货人地址标签")
	private String receiverTagName;

	@Schema(description = "省份/直辖市")
	private String receiverProvince;

	@Schema(description = "城市")
	private String receiverCity;

	@Schema(description = "区")
	private String receiverDistrict;

	@Schema(description = "详细地址")
	private String receiverAddress;

	@Schema(description = "支付时间")
	private Date paymentTime;

	@Schema(description = "发货时间")
	private Date deliveryTime;

	@Schema(description = "确认收货时间")
	private Date receiveTime;

	@Schema(description = "订单备注")
	private String remark;

	@Schema(description = "取消订单时间")
	private Date cancelTime;

	@Schema(description = "取消订单原因")
	private String cancelReason;

	@Schema(description = "订单项列表")
	private List<OrderItem> orderItemList;

}