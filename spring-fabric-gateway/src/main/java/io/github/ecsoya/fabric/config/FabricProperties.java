package io.github.ecsoya.fabric.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import lombok.Data;

/**
 * The root configuration of the fabric and network.
 * 
 * @author ecsoya
 *
 * @see FabricContext
 */
@Data
public class FabricProperties {

	/**
	 * The channel name of fabric, required.
	 * Fabric中Channel的名称是必须存在的。
	 */
	private String channel;

	/**
	 * The organizations of fabric.
	 * Fabric的组织名称。
	 */
	private String[] organizations;

	/**
	 * The name of the fabric.
	 * Fabric的名称。
	 */
	private String name;

	/**
	 * The count of all peers.
	 * Peer结点的个数。
	 */
	private int peers;

	/**
	 * The gateway configuration of fabric.
	 * Fabric 的 Gateway 配置。
	 */
	private FabricGatewayProperties gateway = new FabricGatewayProperties();

	/**
	 * The network configuration of fabric.
	 * Fabric的Network相关配置。
	 */
	protected FabricNetworkProperties network = new FabricNetworkProperties();

	/**
	 * The chaincode configuration of fabric.
	 * 链码相关的配置。
	 */
	private FabricChaincodeProperties chaincode = new FabricChaincodeProperties();

	/**
	 * @return Load the contents of the network.
	 */
	public InputStream getNetworkContents() {
		if (network == null) {
			return null;
		}
		String file = network.getFile();
		if (file == null || file.equals("")) {
			return null;
		}
		File localFile = new File(file);
		if (!localFile.exists()) {
			return null;
		}
		try {
			return new FileInputStream(localFile);
		} catch (FileNotFoundException e) {
			return null;
		}
	}

}
