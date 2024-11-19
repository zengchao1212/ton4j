package org.ton.java.tlb;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.ton.java.cell.Cell;
import org.ton.java.cell.CellBuilder;
import org.ton.java.cell.CellSlice;
import org.ton.java.tlb.types.Transaction;

@Slf4j
@RunWith(JUnit4.class)
public class TestTlbTransactionReader {
    @Test
    public void testLoadTransaction() {
        Cell c = CellBuilder.beginCell().fromBoc("b5ee9c72010226010006990003b570c6e8053cae2db8db1f757877a20451406d17f8ab7e42b88aa3bf6022dd2666200002018ba3f1404177290fd7520f4c9a9cdea0d5c1d972e0f63b75e4114ca8ec24c20211342379800002018ba208f8163eb5649000347372d2680102030201e0040500827292c274ccb4edfb07eeffce3721febf61bb2666d7ee4234f9e01a59b9e8a2a97129422e88bc846f3e65e2c7a05f4ac0954cf243cb7dff41b59bd42138c835a95b02170c40491f4add40186e668611242503b148001b5ba243fca4eba58d090c2fdbcfd5468567018240568edc715af856360479fb00031ba014f2b8b6e36c7dd5e1de88114501b45fe2adf90ae22a8efd808b74999891f4add40006ff7ec000004031747e2806c7d6ac931b0607080101df150114ff00f4a413f4bcf2c80b090059000000000000000000000000bb870617fcc0c46817b359c9399b9bb71b944947102674e4b46a8a9312191735400199285e6041bb8cfb5d60ea1bd3956f9b77a026cfbe07217d221a024b8a12e7fca30bc9c605d27755caba9ae0a66f3494952fdb788f65ba15e99ea1c4148727ec020000000063eb56833a288aabc0130201200a0b0201480c0d0006f2f0010202cf0e0f020120111200231b0c4835d26040982e64cc3e0024bc0078a001e920c235c60834c7f4cffe08ea87d4c82e7c98fb513434c7f4cff4fffd013454d820103d039be84c7c98145ceebca881fe40550421fe443ca8c0bd01347e001fe3858860043d1e1be9482600b4c1f50c007ec0244cb8806cf996e0c96872100d20103d10e2b98c407232c7c4f2cff2fffd00327b5520100034208040f4966fa56c122094305303b9de2093333601926c21e2b30017bd9ce76a26869af98eb85ffc0041be5f976a268698f98e99fe9ff98fa0268a91040207a0737d098c92dbfc95dd1f140104d08014026162007bb97b0fd056eabbb2d09d36ae533b16f545d0fbfbf187685c7c6a115d6d303d000000000000000000000000000232161702b1680018dd00a795c5b71b63eeaf0ef4408a280da2ff156fc857115477ec045ba4ccc5003ddcbd87e82b755dd9684e9b57299d8b7aa2e87dfdf8c3b42e3e3508aeb6981e91f0fc64bc06a18a7c00004031747e280ac7d6ac931916170114ff00f4a413f4bcf2c80b1801d931f5ab23c00585d8b57d25ff490c78aef4d63589f930b510d6e0009ccecfc503eb3c723c362801ca8151271aafc451be2c28cdc132ddc423328db0830c9afb19e99a6d6b62d19500036b74487f949d74b1a12185fb79faa8d0ace030480ad1db8e2b5f0ac6c08f3f50ee6b280223020120191a0201481b1c0004f2300202cd1d1e0051a03859da89a1a601a63ff481f481f481f401a861a1f481f401f481f4006104208c92b0a0158002ab0102f7d00e8698180b8d8492f82707d201876a2686980698ffd207d207d207d006a18136000f968ca116ba4e10159c720191c1c29a0e382c92f847028a26382f970fa02698fc1080289c6c8895d7970fae99f98fd2018202b036465800ae58fa801e78b00e78b00e78b00fd016664f6aa701b13e380718103e98fe99f9810c1f2001f7660840ee6b280149828148c2fbcb87089343e903e803e903e800c14e4a848685421e845a814a41c20043232c15400f3c5807e80b2dab25c7ec00970800975d27080ac2385d4115c20043232c15400f3c5807e80b2dab25c7ec00408e48d0d38969c20043232c15400f3c5807e80b2dab25c7ec01c08208417f30f452220016371038476514433070f005014ac001925f0be021c0029f31104910384760102510241023f005e03ac003e3025f09840ff2f02100ca82103b9aca0018bef2e1c95346c7055152c70515b1f2e1ca702082105fcc3d14218010c8cb0528cf1621fa02cb6acb1f19cb3f27cf1627cf1618ca0027fa0217ca00c98040fb0071065044451506c8cb0015cb1f5003cf1601cf1601cf1601fa02ccc9ed540082218018c8cb052acf1621fa02cb6acb1f13cb3f23cf165003cf16ca0021fa02ca00c98306fb0071555006c8cb0015cb1f5003cf1601cf1601cf1601fa02ccc9ed5400878001b5ba243fca4eba58d090c2fdbcfd5468567018240568edc715af856360479fa100036b74487f949d74b1a12185fb79faa8d0ace030480ad1db8e2b5f0ac6c08f3f42009e43afcc3d090000000000000000007e00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000006fc9bc93d04ca1898800000000000200000000000362a1ec2a403ce96f3234341d66f0c8f2245dfda3293444eca58168c5d17c911643d0c35c").endCell();

        CellSlice cs = CellSlice.beginParse(c);
        Transaction transaction = Transaction.deserialize(cs);
        log.info("transaction {}", transaction);
    }

    @Test
    public void testLoadTransaction2() {
        Cell c = CellBuilder.beginCell().fromBoc("b5ee9c72010226010006990003b570c6e8053cae2db8db1f757877a20451406d17f8ab7e42b88aa3bf6022dd2666200002018ba3f1404177290fd7520f4c9a9cdea0d5c1d972e0f63b75e4114ca8ec24c20211342379800002018ba208f8163eb5649000347372d2680102030201e0040500827292c274ccb4edfb07eeffce3721febf61bb2666d7ee4234f9e01a59b9e8a2a97129422e88bc846f3e65e2c7a05f4ac0954cf243cb7dff41b59bd42138c835a95b02170c40491f4add40186e668611242503b148001b5ba243fca4eba58d090c2fdbcfd5468567018240568edc715af856360479fb00031ba014f2b8b6e36c7dd5e1de88114501b45fe2adf90ae22a8efd808b74999891f4add40006ff7ec000004031747e2806c7d6ac931b0607080101df150114ff00f4a413f4bcf2c80b090059000000000000000000000000bb870617fcc0c46817b359c9399b9bb71b944947102674e4b46a8a9312191735400199285e6041bb8cfb5d60ea1bd3956f9b77a026cfbe07217d221a024b8a12e7fca30bc9c605d27755caba9ae0a66f3494952fdb788f65ba15e99ea1c4148727ec020000000063eb56833a288aabc0130201200a0b0201480c0d0006f2f0010202cf0e0f020120111200231b0c4835d26040982e64cc3e0024bc0078a001e920c235c60834c7f4cffe08ea87d4c82e7c98fb513434c7f4cff4fffd013454d820103d039be84c7c98145ceebca881fe40550421fe443ca8c0bd01347e001fe3858860043d1e1be9482600b4c1f50c007ec0244cb8806cf996e0c96872100d20103d10e2b98c407232c7c4f2cff2fffd00327b5520100034208040f4966fa56c122094305303b9de2093333601926c21e2b30017bd9ce76a26869af98eb85ffc0041be5f976a268698f98e99fe9ff98fa0268a91040207a0737d098c92dbfc95dd1f140104d08014026162007bb97b0fd056eabbb2d09d36ae533b16f545d0fbfbf187685c7c6a115d6d303d000000000000000000000000000232161702b1680018dd00a795c5b71b63eeaf0ef4408a280da2ff156fc857115477ec045ba4ccc5003ddcbd87e82b755dd9684e9b57299d8b7aa2e87dfdf8c3b42e3e3508aeb6981e91f0fc64bc06a18a7c00004031747e280ac7d6ac931916170114ff00f4a413f4bcf2c80b1801d931f5ab23c00585d8b57d25ff490c78aef4d63589f930b510d6e0009ccecfc503eb3c723c362801ca8151271aafc451be2c28cdc132ddc423328db0830c9afb19e99a6d6b62d19500036b74487f949d74b1a12185fb79faa8d0ace030480ad1db8e2b5f0ac6c08f3f50ee6b280223020120191a0201481b1c0004f2300202cd1d1e0051a03859da89a1a601a63ff481f481f481f401a861a1f481f401f481f4006104208c92b0a0158002ab0102f7d00e8698180b8d8492f82707d201876a2686980698ffd207d207d207d006a18136000f968ca116ba4e10159c720191c1c29a0e382c92f847028a26382f970fa02698fc1080289c6c8895d7970fae99f98fd2018202b036465800ae58fa801e78b00e78b00e78b00fd016664f6aa701b13e380718103e98fe99f9810c1f2001f7660840ee6b280149828148c2fbcb87089343e903e803e903e800c14e4a848685421e845a814a41c20043232c15400f3c5807e80b2dab25c7ec00970800975d27080ac2385d4115c20043232c15400f3c5807e80b2dab25c7ec00408e48d0d38969c20043232c15400f3c5807e80b2dab25c7ec01c08208417f30f452220016371038476514433070f005014ac001925f0be021c0029f31104910384760102510241023f005e03ac003e3025f09840ff2f02100ca82103b9aca0018bef2e1c95346c7055152c70515b1f2e1ca702082105fcc3d14218010c8cb0528cf1621fa02cb6acb1f19cb3f27cf1627cf1618ca0027fa0217ca00c98040fb0071065044451506c8cb0015cb1f5003cf1601cf1601cf1601fa02ccc9ed540082218018c8cb052acf1621fa02cb6acb1f13cb3f23cf165003cf16ca0021fa02ca00c98306fb0071555006c8cb0015cb1f5003cf1601cf1601cf1601fa02ccc9ed5400878001b5ba243fca4eba58d090c2fdbcfd5468567018240568edc715af856360479fa100036b74487f949d74b1a12185fb79faa8d0ace030480ad1db8e2b5f0ac6c08f3f42009e43afcc3d090000000000000000007e00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000006fc9bc93d04ca1898800000000000200000000000362a1ec2a403ce96f3234341d66f0c8f2245dfda3293444eca58168c5d17c911643d0c35c").endCell();

        CellSlice cs = CellSlice.beginParse(c);
        Transaction transaction = Transaction.deserialize(cs);
        log.info("transaction {}", transaction);
    }

    @Test
    public void testLoadTransactionPrintWithBlock() {
        Cell c = CellBuilder.beginCell().fromBoc("b5ee9c72010226010006990003b570c6e8053cae2db8db1f757877a20451406d17f8ab7e42b88aa3bf6022dd2666200002018ba3f1404177290fd7520f4c9a9cdea0d5c1d972e0f63b75e4114ca8ec24c20211342379800002018ba208f8163eb5649000347372d2680102030201e0040500827292c274ccb4edfb07eeffce3721febf61bb2666d7ee4234f9e01a59b9e8a2a97129422e88bc846f3e65e2c7a05f4ac0954cf243cb7dff41b59bd42138c835a95b02170c40491f4add40186e668611242503b148001b5ba243fca4eba58d090c2fdbcfd5468567018240568edc715af856360479fb00031ba014f2b8b6e36c7dd5e1de88114501b45fe2adf90ae22a8efd808b74999891f4add40006ff7ec000004031747e2806c7d6ac931b0607080101df150114ff00f4a413f4bcf2c80b090059000000000000000000000000bb870617fcc0c46817b359c9399b9bb71b944947102674e4b46a8a9312191735400199285e6041bb8cfb5d60ea1bd3956f9b77a026cfbe07217d221a024b8a12e7fca30bc9c605d27755caba9ae0a66f3494952fdb788f65ba15e99ea1c4148727ec020000000063eb56833a288aabc0130201200a0b0201480c0d0006f2f0010202cf0e0f020120111200231b0c4835d26040982e64cc3e0024bc0078a001e920c235c60834c7f4cffe08ea87d4c82e7c98fb513434c7f4cff4fffd013454d820103d039be84c7c98145ceebca881fe40550421fe443ca8c0bd01347e001fe3858860043d1e1be9482600b4c1f50c007ec0244cb8806cf996e0c96872100d20103d10e2b98c407232c7c4f2cff2fffd00327b5520100034208040f4966fa56c122094305303b9de2093333601926c21e2b30017bd9ce76a26869af98eb85ffc0041be5f976a268698f98e99fe9ff98fa0268a91040207a0737d098c92dbfc95dd1f140104d08014026162007bb97b0fd056eabbb2d09d36ae533b16f545d0fbfbf187685c7c6a115d6d303d000000000000000000000000000232161702b1680018dd00a795c5b71b63eeaf0ef4408a280da2ff156fc857115477ec045ba4ccc5003ddcbd87e82b755dd9684e9b57299d8b7aa2e87dfdf8c3b42e3e3508aeb6981e91f0fc64bc06a18a7c00004031747e280ac7d6ac931916170114ff00f4a413f4bcf2c80b1801d931f5ab23c00585d8b57d25ff490c78aef4d63589f930b510d6e0009ccecfc503eb3c723c362801ca8151271aafc451be2c28cdc132ddc423328db0830c9afb19e99a6d6b62d19500036b74487f949d74b1a12185fb79faa8d0ace030480ad1db8e2b5f0ac6c08f3f50ee6b280223020120191a0201481b1c0004f2300202cd1d1e0051a03859da89a1a601a63ff481f481f481f401a861a1f481f401f481f4006104208c92b0a0158002ab0102f7d00e8698180b8d8492f82707d201876a2686980698ffd207d207d207d006a18136000f968ca116ba4e10159c720191c1c29a0e382c92f847028a26382f970fa02698fc1080289c6c8895d7970fae99f98fd2018202b036465800ae58fa801e78b00e78b00e78b00fd016664f6aa701b13e380718103e98fe99f9810c1f2001f7660840ee6b280149828148c2fbcb87089343e903e803e903e800c14e4a848685421e845a814a41c20043232c15400f3c5807e80b2dab25c7ec00970800975d27080ac2385d4115c20043232c15400f3c5807e80b2dab25c7ec00408e48d0d38969c20043232c15400f3c5807e80b2dab25c7ec01c08208417f30f452220016371038476514433070f005014ac001925f0be021c0029f31104910384760102510241023f005e03ac003e3025f09840ff2f02100ca82103b9aca0018bef2e1c95346c7055152c70515b1f2e1ca702082105fcc3d14218010c8cb0528cf1621fa02cb6acb1f19cb3f27cf1627cf1618ca0027fa0217ca00c98040fb0071065044451506c8cb0015cb1f5003cf1601cf1601cf1601fa02ccc9ed540082218018c8cb052acf1621fa02cb6acb1f13cb3f23cf165003cf16ca0021fa02ca00c98306fb0071555006c8cb0015cb1f5003cf1601cf1601cf1601fa02ccc9ed5400878001b5ba243fca4eba58d090c2fdbcfd5468567018240568edc715af856360479fa100036b74487f949d74b1a12185fb79faa8d0ace030480ad1db8e2b5f0ac6c08f3f42009e43afcc3d090000000000000000007e00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000006fc9bc93d04ca1898800000000000200000000000362a1ec2a403ce96f3234341d66f0c8f2245dfda3293444eca58168c5d17c911643d0c35c").endCell();

        CellSlice cs = CellSlice.beginParse(c);
        Transaction transaction = Transaction.deserialize(cs);
        log.info("transaction {}", transaction);
        transaction.printTransactionInfo(true, true, "", "(0,600000000000000,233232)");
    }

    @Test
    public void testLoadTransactionPrintNoBlock() {
        Cell c = CellBuilder.beginCell().fromBoc("b5ee9c72010226010006990003b570c6e8053cae2db8db1f757877a20451406d17f8ab7e42b88aa3bf6022dd2666200002018ba3f1404177290fd7520f4c9a9cdea0d5c1d972e0f63b75e4114ca8ec24c20211342379800002018ba208f8163eb5649000347372d2680102030201e0040500827292c274ccb4edfb07eeffce3721febf61bb2666d7ee4234f9e01a59b9e8a2a97129422e88bc846f3e65e2c7a05f4ac0954cf243cb7dff41b59bd42138c835a95b02170c40491f4add40186e668611242503b148001b5ba243fca4eba58d090c2fdbcfd5468567018240568edc715af856360479fb00031ba014f2b8b6e36c7dd5e1de88114501b45fe2adf90ae22a8efd808b74999891f4add40006ff7ec000004031747e2806c7d6ac931b0607080101df150114ff00f4a413f4bcf2c80b090059000000000000000000000000bb870617fcc0c46817b359c9399b9bb71b944947102674e4b46a8a9312191735400199285e6041bb8cfb5d60ea1bd3956f9b77a026cfbe07217d221a024b8a12e7fca30bc9c605d27755caba9ae0a66f3494952fdb788f65ba15e99ea1c4148727ec020000000063eb56833a288aabc0130201200a0b0201480c0d0006f2f0010202cf0e0f020120111200231b0c4835d26040982e64cc3e0024bc0078a001e920c235c60834c7f4cffe08ea87d4c82e7c98fb513434c7f4cff4fffd013454d820103d039be84c7c98145ceebca881fe40550421fe443ca8c0bd01347e001fe3858860043d1e1be9482600b4c1f50c007ec0244cb8806cf996e0c96872100d20103d10e2b98c407232c7c4f2cff2fffd00327b5520100034208040f4966fa56c122094305303b9de2093333601926c21e2b30017bd9ce76a26869af98eb85ffc0041be5f976a268698f98e99fe9ff98fa0268a91040207a0737d098c92dbfc95dd1f140104d08014026162007bb97b0fd056eabbb2d09d36ae533b16f545d0fbfbf187685c7c6a115d6d303d000000000000000000000000000232161702b1680018dd00a795c5b71b63eeaf0ef4408a280da2ff156fc857115477ec045ba4ccc5003ddcbd87e82b755dd9684e9b57299d8b7aa2e87dfdf8c3b42e3e3508aeb6981e91f0fc64bc06a18a7c00004031747e280ac7d6ac931916170114ff00f4a413f4bcf2c80b1801d931f5ab23c00585d8b57d25ff490c78aef4d63589f930b510d6e0009ccecfc503eb3c723c362801ca8151271aafc451be2c28cdc132ddc423328db0830c9afb19e99a6d6b62d19500036b74487f949d74b1a12185fb79faa8d0ace030480ad1db8e2b5f0ac6c08f3f50ee6b280223020120191a0201481b1c0004f2300202cd1d1e0051a03859da89a1a601a63ff481f481f481f401a861a1f481f401f481f4006104208c92b0a0158002ab0102f7d00e8698180b8d8492f82707d201876a2686980698ffd207d207d207d006a18136000f968ca116ba4e10159c720191c1c29a0e382c92f847028a26382f970fa02698fc1080289c6c8895d7970fae99f98fd2018202b036465800ae58fa801e78b00e78b00e78b00fd016664f6aa701b13e380718103e98fe99f9810c1f2001f7660840ee6b280149828148c2fbcb87089343e903e803e903e800c14e4a848685421e845a814a41c20043232c15400f3c5807e80b2dab25c7ec00970800975d27080ac2385d4115c20043232c15400f3c5807e80b2dab25c7ec00408e48d0d38969c20043232c15400f3c5807e80b2dab25c7ec01c08208417f30f452220016371038476514433070f005014ac001925f0be021c0029f31104910384760102510241023f005e03ac003e3025f09840ff2f02100ca82103b9aca0018bef2e1c95346c7055152c70515b1f2e1ca702082105fcc3d14218010c8cb0528cf1621fa02cb6acb1f19cb3f27cf1627cf1618ca0027fa0217ca00c98040fb0071065044451506c8cb0015cb1f5003cf1601cf1601cf1601fa02ccc9ed540082218018c8cb052acf1621fa02cb6acb1f13cb3f23cf165003cf16ca0021fa02ca00c98306fb0071555006c8cb0015cb1f5003cf1601cf1601cf1601fa02ccc9ed5400878001b5ba243fca4eba58d090c2fdbcfd5468567018240568edc715af856360479fa100036b74487f949d74b1a12185fb79faa8d0ace030480ad1db8e2b5f0ac6c08f3f42009e43afcc3d090000000000000000007e00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000006fc9bc93d04ca1898800000000000200000000000362a1ec2a403ce96f3234341d66f0c8f2245dfda3293444eca58168c5d17c911643d0c35c").endCell();

        CellSlice cs = CellSlice.beginParse(c);
        Transaction transaction = Transaction.deserialize(cs);
        log.info("transaction {}", transaction);
        transaction.printTransactionInfo(true, true, "");
    }
}