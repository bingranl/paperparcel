package nz.bradcampbell.paperparcel.internal.properties;

import static nz.bradcampbell.paperparcel.internal.utils.PropertyUtils.literal;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;
import nz.bradcampbell.paperparcel.internal.Property;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class TypeAdapterProperty extends Property {
  private final ClassName typeAdapter;

  public TypeAdapterProperty(ClassName typeAdapter, boolean isNullable, TypeName typeName, boolean isInterface,
                             String name, @Nullable String accessorMethodName) {
    super(isNullable, typeName, isInterface, name, accessorMethodName);
    this.typeAdapter = typeAdapter;
  }

  @Override
  protected CodeBlock readFromParcelInner(CodeBlock.Builder block, ParameterSpec in, @Nullable FieldSpec classLoader,
                                          Map<ClassName, FieldSpec> typeAdapters) {
    return literal("$N.readFromParcel($N)", typeAdapters.get(typeAdapter), in);
  }

  @Override
  protected void writeToParcelInner(CodeBlock.Builder block, ParameterSpec dest, CodeBlock sourceLiteral,
                                    Map<ClassName, FieldSpec> typeAdapters) {
    block.addStatement("$N.writeToParcel($L, $N)", typeAdapters.get(typeAdapter), sourceLiteral, dest);
  }

  @Override public Set<ClassName> requiredTypeAdapters() {
    return Collections.singleton(typeAdapter);
  }
}
