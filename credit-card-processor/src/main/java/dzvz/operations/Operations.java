package dzvz.operations;

import java.util.stream.Stream;

/**
 * Created by dzmirtyviarzhbitski on 2/17/16.
 */
public enum Operations {
  ADD,
  CHARGE,
  CREDIT,
  SUMMARY;

  public static Operations safeValueOf(final String command){
      return Stream.of(Operations.values()).filter(v-> v.name().equalsIgnoreCase(command)).findFirst().orElseGet(null);
  }
}
