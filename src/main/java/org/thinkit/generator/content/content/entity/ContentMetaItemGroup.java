/*
 * Copyright 2020 Kato Shinya.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.thinkit.generator.content.content.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.thinkit.common.util.iterator.FluentIterator;
import org.thinkit.common.util.iterator.IterableNode;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * コンテンツ「コンテンツメタ項目」のオブジェクトグループを管理するデータクラスです。
 * <p>
 * このクラスはFluentインターフェースの概念を応用し設計されています。<br>
 * そのため、以下のようなメソッドチェーンでの操作が可能です。
 *
 * <pre>
 * <code>
 * ContentMetaItemGroup contentMetaItemGroup = ContentMetaItemGroup.of()
 *                                  .add(contentMetaItem1)
 *                                  .add(contentMetaItem2);
 * </code>
 * </pre>
 *
 * @author Kato Shinya
 * @since 1.0
 * @version 1.0
 */
@ToString
@EqualsAndHashCode
public final class ContentMetaItemGroup
        implements Iterable<ContentMetaItem>, IterableNode<ContentMetaItem>, Serializable {

    /**
     * シリアルバージョンUID
     */
    private static final long serialVersionUID = 5501189774410411268L;

    /**
     * コンテンツメタ項目グループ
     */
    @Getter
    private List<ContentMetaItem> contentMetaItemGroup;

    /**
     * コンテンツメタ項目グループのサイズ
     */
    private int size;

    /**
     * デフォルトコンストラクタ
     */
    private ContentMetaItemGroup() {
        this.contentMetaItemGroup = new ArrayList<>(0);
        this.size = 0;
    }

    /**
     * コピーコンストラクタ
     *
     * @param contentMetaItemGroup コンテンツメタ項目グループ
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    private ContentMetaItemGroup(@NonNull ContentMetaItemGroup contentMetaItemGroup) {
        this.contentMetaItemGroup = new ArrayList<>(contentMetaItemGroup.getContentMetaItemGroup());
    }

    /**
     * {@link ContentMetaItemGroup} クラスの新しいインスタンスを生成し返却します。
     *
     * @return {@link ContentMetaItemGroup} クラスの新しいインスタンス
     */
    public static ContentMetaItemGroup of() {
        return new ContentMetaItemGroup();
    }

    /**
     * 引数として渡された {@code contentMetaItemGroup} オブジェクトの情報を基に
     * {@link ContentMetaItemGroup} クラスの新しいインスタンスを生成し返却します。
     *
     * @param contentMetaItemGroup コンテンツメタ項目グループ
     * @return {@link ContentMetaItemGroup} クラスの新しいインスタンス
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    public static ContentMetaItemGroup of(@NonNull ContentMetaItemGroup contentMetaItemGroup) {
        return new ContentMetaItemGroup(contentMetaItemGroup);
    }

    /**
     * 引数として渡された {@code contentMetaItem} を条件リストへ追加します。
     * <p>
     * この {@link ContentMetaItemGroup#add(ContentMetaItem)}
     * メソッドは自分自身のインスタンスを返却するため以下のようなメソッドチェーンでの操作が可能です。
     *
     * <pre>
     * <code>
     * ContentMetaItemGroup contentMetaItemGroup = ContentMetaItemGroup.of()
     *                                  .add(contentMetaItem1)
     *                                  .add(contentMetaItem2);
     * </code>
     * </pre>
     *
     * @param ContentMetaItem コンテンツメタ項目
     * @return 自分自身のインスタンス
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    public ContentMetaItemGroup add(@NonNull ContentMetaItem ContentMetaItem) {
        this.contentMetaItemGroup.add(ContentMetaItem);
        size++;

        return this;
    }

    /**
     * オブジェクトに含まれる情報が空か判定します。
     *
     * @return オブジェクトに含まれる情報がからの場合は {@code true} 、それ以外は {@code false}
     */
    public boolean isEmpty() {
        return this.size <= 0;
    }

    /**
     * {@link ContentMetaItem} クラスを総称型として持つストリームを返却します。
     *
     * @return {@link ContentMetaItem} クラスを総称型として持つストリーム
     */
    public Stream<ContentMetaItem> stream() {
        return this.contentMetaItemGroup.stream();
    }

    @Override
    public List<ContentMetaItem> nodes() {
        return this.contentMetaItemGroup;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<ContentMetaItem> iterator() {
        return FluentIterator.of(this);
    }
}