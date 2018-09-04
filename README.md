#### EOS Java Client
#### 本项目参考自 [espritblock/eos4j](https://github.com/espritblock/eos4j)

#### 特点

* 对数据结构进行了重新定义
* 支持本地交易签名并生成交易txId
* 对EOS RPC接口返回值做了兼容
* 兼容fc数据的序列化方式

#### 使用帮助

```java
/**
 * 获取块高度
 * 
 * @return @
 * @throws IOException 
 * @throws ApiException 
 */
public Integer getBlockNumber() throws ApiException, IOException {
    return eos4j.getChainInfo().getHeadBlockNum().intValue();
}

/**
 * 安全块高度
 * 
 * @return @
 * @throws IOException 
 * @throws ApiException 
 */
public Integer getSafeBlockNumber() throws ApiException, IOException {
    return eos4j.getChainInfo().getLastIrreversibleBlockNum().intValue();
}

/**
 * 获取指定区块信息
 * 
 * @param blockNumber
 * @return 
 * @return @
 * @throws IOException 
 */
public GetBlockResult getBlock(String blockNumOrId) throws IOException {
    return eos4j.getBlock(blockNumOrId);
}

/**
 * 根据交易id获取
 * 
 * @param txId
 * @return 
 * @return @
 * @throws IOException 
 */
public GetTransactionResult getTransaction(String txId) throws IOException {
    return eos4j.getTransaction(txId);
}

/**
 * 获取contractAddress下的balanceAddress余额
 * 
 * @param balanceAddress
 * @param contractAddress
 * @return @
 * @throws IOException 
 * @throws ApiException 
 */
public BigDecimal getTokenBlanceOf(String balanceAccount, String contractAccount, String symbol) throws ApiException, IOException {
    return eos4j.getCurrencyBalance(balanceAccount, contractAccount, symbol);
}

/**
 * 创建账号
 * @param accountName
 * @param pubKey 
 * @return
 * @throws IOException 
 * @throws ApiException 
 */
public String createAccount(String accountName, String pubKey) throws ApiException, IOException {
    return eos4j.createAccount(privateKey, creator, accountName, pubKey, pubKey, buyRam, stakeNetQuantity, stakeCpuQuantity, transfer).getTransactionId();
}
/**
 * 组装转账交易
 * @param pk
 * @param contractAccount
 * @param from
 * @param to
 * @param quantity
 * @param memo
 * @return
 * @throws IOException 
 * @throws ApiException 
 * @throws Exception
 */
public SignedTransactionToPush assembleTransferRawTx(String pk, String contractAccount, String from,
                                                     String to, String quantity, String memo) throws ApiException, IOException {
    return eos4j.txBuilder().buildTransferRawTx(pk, contractAccount, from, to, quantity, memo);
}
/**
 * 发送交易
 * @param signedMessage
 * @return
 * @throws IOException 
 * @throws ApiException 
 * @throws Exception
 */
public String pushTransaction(SignedTransactionToPush signedMessage) throws ApiException, IOException {
    return eos4j.pushTransaction(signedMessage).getTransactionId();
}
/**
 * 获取公钥下所有账号
 * @param pubKey
 * @return
 * @throws ApiException
 * @throws IOException
 */
public List<String> getAccountList(String pubKey) throws ApiException, IOException {
    return eos4j.getAccounts(pubKey);
}
/**
 * 获取账号
 * @param accountName
 * @return
 * @throws IOException
 */
public GetAccountResults getAccount(String accountName) throws IOException {
    return eos4j.getAccount(accountName);
}
```

