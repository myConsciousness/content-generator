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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * コンテンツ「コンテンツ作成者項目」の情報を管理するデータクラスです。
 *
 * @author Kato Shinya
 * @since 1.0
 * @version 1.0
 */
@Getter
@ToString
@EqualsAndHashCode
public final class ContentCreatorItem implements Serializable {

    /**
     * シリアルバージョンUID
     */
    private static final long serialVersionUID = 8657905398814586601L;

    /**
     * セル項目コード
     */
    private int cellItemCode;

    /**
     * セル項目名
     */
    private String cellItemName;

    /**
     * デフォルトコンストラクタ
     */
    private ContentCreatorItem() {
    }

    /**
     * コンストラクタ
     *
     * @param cellItemCode セル項目コード
     * @param cellItemName セル項目名
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    private ContentCreatorItem(int cellItemCode, @NonNull String cellItemName) {
        this.cellItemCode = cellItemCode;
        this.cellItemName = cellItemName;
    }

    /**
     * コピーコンストラクタ
     *
     * @param contentCreatorItem コンテンツ作成者項目
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    private ContentCreatorItem(@NonNull ContentCreatorItem contentCreatorItem) {
        this.cellItemCode = contentCreatorItem.getCellItemCode();
        this.cellItemName = contentCreatorItem.getCellItemName();
    }

    /**
     * 引数として渡された情報を基に {@link ContentCreatorItem} クラスの新しいインスタンスを生成し返却します。
     *
     * @param cellItemCode セル項目コード
     * @param cellItemName セル項目名
     * @return {@link ContentCreatorItem} クラスの新しいインスタンス
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    public static ContentCreatorItem of(int cellItemCode, @NonNull String cellItemName) {
        return new ContentCreatorItem(cellItemCode, cellItemName);
    }

    /**
     * 引数として渡された {@code contentCreatorItem} オブジェクトの情報を基に {@link ContentCreatorItem}
     * クラスの新しいインスタンスを生成し返却します。
     *
     * @param contentCreatorItem コンテンツ作成者項目
     * @return {@link ContentCreatorItem} クラスの新しいインスタンス
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    public static ContentCreatorItem of(@NonNull ContentCreatorItem contentCreatorItem) {
        return new ContentCreatorItem(contentCreatorItem);
    }
}