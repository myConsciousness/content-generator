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
 * コンテンツ「コンテンツ作成者項目」のオブジェクトグループを管理するデータクラスです。
 * <p>
 * このクラスはFluentインターフェースの概念を応用し設計されています。<br>
 * そのため、以下のようなメソッドチェーンでの操作が可能です。
 *
 * <pre>
 * <code>
 * ContentCreatorItemGroup contentCreatorItemGroup = ContentCreatorItemGroup.of()
 *                                  .add(contentCreatorItem1)
 *                                  .add(contentCreatorItem2);
 * </code>
 * </pre>
 *
 * @author Kato Shinya
 * @since 1.0
 * @version 1.0
 */
@ToString
@EqualsAndHashCode
public final class ContentCreatorItemGroup
        implements Iterable<ContentCreatorItem>, IterableNode<ContentCreatorItem>, Serializable {

    /**
     * シリアルバージョンUID
     */
    private static final long serialVersionUID = 5501189774410411268L;

    /**
     * コンテンツ作成者項目グループ
     */
    @Getter
    private List<ContentCreatorItem> contentCreatorItemGroup;

    /**
     * コンテンツ作成者項目グループのサイズ
     */
    private int size;

    /**
     * デフォルトコンストラクタ
     */
    private ContentCreatorItemGroup() {
        this.contentCreatorItemGroup = new ArrayList<>(0);
        this.size = 0;
    }

    /**
     * コピーコンストラクタ
     *
     * @param contentCreatorItemGroup コンテンツ作成者項目グループ
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    private ContentCreatorItemGroup(@NonNull ContentCreatorItemGroup contentCreatorItemGroup) {
        this.contentCreatorItemGroup = new ArrayList<>(contentCreatorItemGroup.getContentCreatorItemGroup());
    }

    /**
     * {@link ContentCreatorItemGroup} クラスの新しいインスタンスを生成し返却します。
     *
     * @return {@link ContentCreatorItemGroup} クラスの新しいインスタンス
     */
    public static ContentCreatorItemGroup of() {
        return new ContentCreatorItemGroup();
    }

    /**
     * 引数として渡された {@code contentCreatorItemGroup} オブジェクトの情報を基に
     * {@link ContentCreatorItemGroup} クラスの新しいインスタンスを生成し返却します。
     *
     * @param contentCreatorItemGroup コンテンツ作成者項目グループ
     * @return {@link ContentCreatorItemGroup} クラスの新しいインスタンス
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    public static ContentCreatorItemGroup of(@NonNull ContentCreatorItemGroup contentCreatorItemGroup) {
        return new ContentCreatorItemGroup(contentCreatorItemGroup);
    }

    /**
     * 引数として渡された {@code contentCreatorItem} を条件リストへ追加します。
     * <p>
     * この {@link ContentCreatorItemGroup#add(ContentCreatorItem)}
     * メソッドは自分自身のインスタンスを返却するため以下のようなメソッドチェーンでの操作が可能です。
     *
     * <pre>
     * <code>
     * ContentCreatorItemGroup contentCreatorItemGroup = ContentCreatorItemGroup.of()
     *                                  .add(contentCreatorItem1)
     *                                  .add(contentCreatorItem2);
     * </code>
     * </pre>
     *
     * @param ContentCreatorItem コンテンツ作成者項目
     * @return 自分自身のインスタンス
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    public ContentCreatorItemGroup add(@NonNull ContentCreatorItem ContentCreatorItem) {
        this.contentCreatorItemGroup.add(ContentCreatorItem);
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
     * {@link ContentCreatorItem} クラスを総称型として持つストリームを返却します。
     *
     * @return {@link ContentCreatorItem} クラスを総称型として持つストリーム
     */
    public Stream<ContentCreatorItem> stream() {
        return this.contentCreatorItemGroup.stream();
    }

    @Override
    public List<ContentCreatorItem> nodes() {
        return this.contentCreatorItemGroup;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<ContentCreatorItem> iterator() {
        return FluentIterator.of(this);
    }
}