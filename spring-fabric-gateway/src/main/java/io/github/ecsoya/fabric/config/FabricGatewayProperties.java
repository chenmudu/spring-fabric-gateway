package io.github.ecsoya.fabric.config;

import org.hyperledger.fabric.gateway.Gateway;
import org.hyperledger.fabric.gateway.impl.GatewayImpl;

import lombok.Data;

/**
 * The configuration properties of the {@link Gateway}.
 * 
 * @author ecsoya
 *
 */
@Data
public class FabricGatewayProperties {

	/**
	 * The timeout of committing to fabric, the unit is minutes.
	 * 
	 * The default value of fabric gateway is 5 minutes, here I increased it to 10
	 * minutes.
	 *  Gateway相关的超时 操作。
	 * @see GatewayImpl
	 */
	private long commitTimeout = 10;   //提交的超时时间延长至10min.

	/**
	 * @since 1.0.6
	 */
	private long ordererTimeout = 60; // seconds

	/**
	 * @since 1.0.6
	 */
	private long proposalTimeout = 5; // seconds   提议请求的超时时间。

	/**
	 * Discovery of gateway builder.
	 * 
	 * @see GatewayImpl
	 */
	private boolean discovery = false;

	/**
	 * The commitHandler class name
	 * 
	 * @see GatewayImpl
	 */
	private String commitHandler;

	/**
	 * The queryHandler class name.
	 * 
	 * @see GatewayImpl
	 */
	private String queryHandler;

	/**
	 * The wallet configuration of gateway.
	 *
	 * Gateway下的wallet。代表一组身份？
	 *
	 * @see GatewayImpl
	 */
	private FabricWalletProperties wallet = new FabricWalletProperties();

}
