Feature: BlockCode

  @API
  Scenario: Verify blockCode operation
    Given I perform operation for "/block-code" with body
      |areaCode   |isCppOrMpp |tecnology |
      |221         |Y          |GSM       |

    Then I should see the blockCode as "AM005"

