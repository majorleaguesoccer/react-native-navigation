const NavigationOptions = require('./NavigationOptions');
const TabBar = require('./TabBar');
const TopBar = require('./TopBar');

const TAB_BAR = {};
const TOP_BAR = {};
const RIGHT_BUTTONS = [
  {
    id: 'myBtn',
    testID: 'BTN',
    title: 'My Button',
    color: 'red'
  }
];
const LEFT_BUTTONS = [
  {
    id: 'myBtn',
    testID: 'BTN',
    title: 'My Button',
    color: 'red'
  }
];
const NAVIGATION_OPTIONS = {
  topBar: TOP_BAR,
  bottomTabs: TAB_BAR,
  orientation: 'portrait',
  rightButtons: RIGHT_BUTTONS,
  leftButtons: LEFT_BUTTONS
};

describe('NavigationOptions', () => {
  it('parses navigationOptions correctly', () => {
    const uut = new NavigationOptions(NAVIGATION_OPTIONS);
    expect(uut.bottomTabs).toBeInstanceOf(TabBar);
    expect(uut.topBar).toBeInstanceOf(TopBar);
    expect(uut.orientation).toEqual('portrait');
    expect(uut.rightButtons).toEqual(RIGHT_BUTTONS);
    expect(uut.leftButtons).toEqual(LEFT_BUTTONS);
  });
});