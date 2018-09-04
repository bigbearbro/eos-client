package io.bigbearbro.eos4j.client.transaction;

import java.util.List;

import io.bigbearbro.eos4j.eosio.chain.action.Action;

public interface ActionCollector {
	public List<Action> collectActions();
}
