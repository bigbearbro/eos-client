package io.bigbearbro.eos4j.api.request.push_transaction.action;

import io.bigbearbro.eos4j.client.pack.PackUtils;
import io.bigbearbro.eos4j.utils.ByteBuffer;
import io.bigbearbro.eos4j.utils.Hex;

public class BaseActionData {

	public String toString() {
		ByteBuffer bb = new ByteBuffer();
		PackUtils.packObj(this, bb);
		return Hex.bytesToHexString(bb.getBuffer());
	}
}
