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

package org.thinkit.generator;

import org.thinkit.generator.common.Generator;
import org.thinkit.generator.workbook.common.AbstractGenerator;
import org.thinkit.generator.workbook.common.DefinitionPath;

import lombok.NonNull;

/**
 * コンテンツ定義書を解析してコンテンツファイルを生成する処理を定義したクラスです。
 *
 * @author Kato Shinya
 * @since 1.0
 * @version 1.0
 */
public final class ContentGenerator extends AbstractGenerator {

    /**
     * コンストラクタ
     *
     * @param definitionPath 生成するパスを管理するオブジェクト
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    private ContentGenerator(@NonNull DefinitionPath definitionPath) {
        super(definitionPath);
    }

    /**
     * 引数として渡された {@code definitionPath} を基に {@link ContentGenerator}
     * クラスの新しいインスタンスを生成し返却します。
     *
     * @param definitionPath 生成するパスを管理するオブジェクト
     * @return {@link ContentGenerator} クラスの新しいインスタンス
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    public static Generator of(@NonNull DefinitionPath definitionPath) {
        return new ContentGenerator(definitionPath);
    }

    @Override
    protected boolean run() {
        return true;
    }
}
