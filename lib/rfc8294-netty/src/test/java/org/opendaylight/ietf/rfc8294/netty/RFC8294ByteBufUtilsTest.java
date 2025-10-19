/*
 * Copyright (c) 2019 PANTHEON.tech, s.r.o. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.ietf.rfc8294.netty;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.jupiter.api.Test;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.routing.types.rev171204.Uint24;
import org.opendaylight.yangtools.yang.common.Uint32;

class RFC8294ByteBufUtilsTest {
    private static final Uint24 ONE_TWO_THREE = new Uint24(Uint32.valueOf(0x010203));

    @Test
    void testRead() {
        final ByteBuf buf = Unpooled.buffer().writeMedium(0x010203);
        assertEquals(ONE_TWO_THREE, RFC8294ByteBufUtils.readUint24(buf));
        assertEquals(0, buf.readableBytes());
    }

    @Test
    void testWrite() {
        final ByteBuf buf = Unpooled.buffer();
        RFC8294ByteBufUtils.writeUint24(buf, ONE_TWO_THREE);
        assertMedium(buf);
    }

    @Test
    void testWriteMandatory() {
        final ByteBuf buf = Unpooled.buffer();
        RFC8294ByteBufUtils.writeMandatoryUint24(buf, ONE_TWO_THREE, "foo");
        assertMedium(buf);
    }

    @Test
    void testWriteMandatoryNull() {
        final var ex = assertThrows(IllegalArgumentException.class,
            () -> RFC8294ByteBufUtils.writeMandatoryUint24(Unpooled.buffer(), null, "foo"));
        assertEquals("foo is mandatory", ex.getMessage());
    }

    @Test
    void testWriteOptional() {
        final var buf = Unpooled.buffer();
        RFC8294ByteBufUtils.writeOptionalUint24(buf, ONE_TWO_THREE);
        assertMedium(buf);
    }

    @Test
    void testWriteOptionalNull() {
        final var buf = Unpooled.buffer();
        RFC8294ByteBufUtils.writeOptionalUint24(buf, null);
        assertEquals(0, buf.readableBytes());
    }

    @Test
    void testWriteOrZero() {
        final var buf = Unpooled.buffer();
        RFC8294ByteBufUtils.writeUint24OrZero(buf, ONE_TWO_THREE);
        assertMedium(buf);
    }

    @Test
    void testWriteOrZeroNull() {
        final var buf = Unpooled.buffer();
        RFC8294ByteBufUtils.writeUint24OrZero(buf, null);
        assertMedium(buf, 0);
    }

    private static void assertMedium(final ByteBuf buf) {
        assertMedium(buf, 0x010203);
    }

    private static void assertMedium(final ByteBuf buf, final int value) {
        assertEquals(3, buf.readableBytes());
        assertEquals(value, buf.readMedium());
    }
}
